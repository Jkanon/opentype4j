# opentype4j
Java library for OpenType font file parsing

API
===
### Loading a font
```java
Font font = OpenType.parse(filePath);
System.out.println(font.getPath("you are right").toSVG())
```

### The Font object
A Font represents a loaded OpenType font file. 
##### `Font.getPath(String text)`
Convert specified to a Path object with default size. 

##### `Font.getPath()`
Convert all glyph to a Path object with default size. (default: 16 fonts in one line and per font with size of 44*40)

##### `Font.nameToGlyph(String name)`
Convert the given glyph name to a single GlyphData object.

### The GlyphData object
A Glyph is an individual mark that often corresponds to a character. 
#### `GlyphData.getPath()`
Get a glyph Path object with default size(44*40) we can use to export(eg. saving as a svg file).
#### `GlyphData.getPath(FontCell fontCell)`
Get a glyph Path object with specified size(fontCell) we can use to export(eg. saving as a svg file).

* `fontCell`: An outer bounds of a cell where a font will be rendered in

### The Path object
A Path containing a set of path commands similar to a SVG path.
##### `Path.toSVG()`
Convert the path to a string of svg dom.

##### `Path.toSVG(String filePath)`
Save the path as a svg file which locate in the filePath

##### `Path.toImage(File file)`
Save the path as a JPEG file

##### `Path.toImage(File file, ImageFormat format)`
Save the path as an image file specified by format.
Supporting for JPEG or PNG format currently

##### `Path.toImageBytes()`
Convert the path to byte array of a jpeg image

##### `Path.toImageBytes(ImageFormat format)`
Convert the path to byte array of specified image format

## License

MIT
