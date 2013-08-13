package br.ufba.dcc.mestrado.computacao.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import br.ufba.dcc.mestrado.computacao.beanutils.converters.OhLohDTO2EntityConverter;
import br.ufba.dcc.mestrado.computacao.ohloh.data.OhLohResultDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.data.analysis.OhLohAnalysisLanguagesDTO;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.OhLohBaseEntity;
import br.ufba.dcc.mestrado.computacao.ohloh.entities.analysis.OhLohAnalysisLanguagesEntity;

public class ConverterHandler<DTO extends OhLohResultDTO, E extends OhLohBaseEntity> {
	
	private Class<DTO> dtoClass;
	private Class<E> entityClass;

	static {
		ConvertUtils.register(new OhLohDTO2EntityConverter<>(OhLohAnalysisLanguagesDTO.class, OhLohAnalysisLanguagesEntity.class), OhLohAnalysisLanguagesEntity.class);
	}
	
	public ConverterHandler(Class<DTO> dtoClass, Class<E> entityClass) {
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	protected Object deepCopySingleValue(Object origValue, Class<?> originClass, Class<?> destClass) throws Exception {
		if (origValue == null) {
			return null;
		}
		
		Object destValue = destClass.newInstance();		
		BeanUtils.copyProperties(destValue, origValue);
		
		for (Field field : originClass.getDeclaredFields()) {
			String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			String setMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			
			if (Collection.class.isAssignableFrom(field.getType())) {
				Method getOrigMethod = originClass.getDeclaredMethod(getMethodName);
				
				if (getOrigMethod.invoke(origValue) != null) {
					Collection destCollection = deepCopyCollectionValue(
							origValue, 
							field,
							destValue,
							destClass.getDeclaredField(field.getName()),
							getOrigMethod);
				
					
					ParameterizedType itemDestParameterizedType = (ParameterizedType) destClass.getDeclaredField(field.getName()).getGenericType();
					
					Method setDestMethod = destClass.getDeclaredMethod(
							setMethodName,
							(Class<?>) itemDestParameterizedType.getRawType());
					setDestMethod.invoke(destValue, field.getType().cast(destCollection));
				}
			} else if (OhLohResultDTO.class.isAssignableFrom(field.getType())) {			
				Method getMethod = originClass.getDeclaredMethod(getMethodName);
					
				if (getMethod.invoke(origValue) != null) {
					Object destFieldObject = deepCopySingleValue(
							getMethod.invoke(origValue),  
							field.getType(), 
							destClass.getDeclaredField(field.getName()).getClass());
					
					destClass.getDeclaredField(field.getName()).set(destValue, destFieldObject);					
				}
				
			}
		}
		
		return destValue;
	}
	
	/**
	 * @param origValue
	 * @param origField
	 * @param getOrigMethod
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws Exception
	 */
	private Collection deepCopyCollectionValue(Object origValue, Field origField, Object destValue, Field destField, Method getOrigMethod) throws Exception{
		
		ParameterizedType itemOrigParameterizedType = (ParameterizedType) origField.getGenericType();
		ParameterizedType itemDestParameterizedType = (ParameterizedType) destField.getGenericType();
		
		Class<?> itemOrigClass = (Class<?>) itemOrigParameterizedType.getActualTypeArguments()[0];
		Class<?> itemDestClass = (Class<?>) itemDestParameterizedType.getActualTypeArguments()[0];
		
		Collection origCollection = (Collection) getOrigMethod.invoke(origValue);
		Collection destCollection = new ArrayList();
		
		for (Object itemOrigValue : origCollection) {
			Object itemDestValue = deepCopySingleValue(itemOrigValue, itemOrigClass, itemDestClass);
			destCollection.add(itemDestValue);
		}
		
		return destCollection;
	}
	
	public E buildEntity(DTO dto) throws Exception {
		E entity = entityClass.newInstance();

		BeanUtils.copyProperties(entity, dto);

		for (Field field : dtoClass.getDeclaredFields()) {
			String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			String setMethodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			
			if (Collection.class.isAssignableFrom(field.getType())) {
				Method getOrigMethod = dtoClass.getDeclaredMethod(getMethodName);
				
				if (getOrigMethod.invoke(dto) != null) {
					Collection destCollection = deepCopyCollectionValue(
							dto, 
							field,
							entity,
							entityClass.getDeclaredField(field.getName()),
							getOrigMethod);
				
					Method setDestMethod = entityClass.getDeclaredMethod(
							setMethodName, 
							entityClass.getDeclaredField(field.getName()).getType()
							);
					setDestMethod.invoke(entity, field.getType().cast(destCollection));
				}
			} else if (OhLohResultDTO.class.isAssignableFrom(field.getType())) {
				Method getMethod = dtoClass.getDeclaredMethod(getMethodName);
				if (getMethod.invoke(dto) != null) {
					Object destFieldObject = deepCopySingleValue(
							getMethod.invoke(dto), 
							field.getType(), 
							entityClass.getDeclaredField(field.getName()).getType());
					
					Method setMethod = entityClass.getDeclaredMethod(setMethodName, entityClass.getDeclaredField(field.getName()).getType());
					setMethod.invoke(entity, entityClass.getDeclaredField(field.getName()).getType().cast(destFieldObject));
				}
			} 
		}

		return entity;
	}
	
}
