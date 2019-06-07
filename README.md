# opentype4j
Java library for OpenType font file parsing

API
===
### Loading a font
```java
Font font = OpenType.parse(filePath);
GlyphDataList glyphs = font.getGlyphs();
System.out.println(font.nameToGlyph("one").getPath().toSVG())
```

### The Font object
A Font represents a loaded OpenType font file. 
##### `Font.nameToGlyph(String name)`
Convert the given glyph name to a single GlyphData object.

### The GlyphData object
A Glyph is an individual mark that often corresponds to a character. 
#### `GlyphData.getPath()`
Get a glyph Path object we can use to export(eg. saving as a svg file).

### The Path object
A Path containing a set of path commands similar to a SVG path.
##### `Path.toSVG()`
Convert the path to a string of svg dom.

##### `Path.toSVG(String filePath)`
Save the path as a svg file which locate in the filePath

## License

MIT
