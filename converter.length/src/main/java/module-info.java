/**
 *
 */
module converter.length {
	requires java.base;
	requires transitive java.desktop;
	requires converter.spi;

	exports converter.length;

	provides converter.spi.ConverterPanel with converter.length.LengthPanel;
}