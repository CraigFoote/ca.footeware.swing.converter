/**
 *
 */
module converter.app {
	requires java.base;
	requires transitive java.desktop;
	requires converter.spi;
	uses converter.spi.ConverterPanel;
}