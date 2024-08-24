/**
 * 
 */
module converter.temperature {
	requires java.base;
	requires transitive java.desktop;
	requires converter.spi;
	exports converter.temperature;
	provides converter.spi.ConverterPanel
	with converter.temperature.TemperaturePanel;
}