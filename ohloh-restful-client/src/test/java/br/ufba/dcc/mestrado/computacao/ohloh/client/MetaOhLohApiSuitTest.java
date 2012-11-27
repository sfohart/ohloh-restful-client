package br.ufba.dcc.mestrado.computacao.ohloh.client;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(value=Suite.class)
@SuiteClasses(value={
		MetaOhLohApiAnalysisTest.class,
		MetaOhLohApiFactoidTest.class,
		MetaOhLohApiAccountTest.class,
		MetaOhLohApiProjectTest.class,
		MetaOhLohApiStackTest.class,
		MetaOhLohApiContributorFactTest.class,
		MetaOhLohApiActivityFactTest.class,
		MetaOhLohApiEnlistmentTest.class,
		MetaOhLohApiKudoTest.class
})
public class MetaOhLohApiSuitTest {

}
