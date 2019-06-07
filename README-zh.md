# opentype4j
开放字体文件JAVA解析库

API
===
### 加载字体文件
```java
Font font = OpenType.parse(filePath);
GlyphDataList glyphs = font.getGlyphs();
System.out.println(font.nameToGlyph("one").getPath().toSVG())
```

### Font类
一个Font类对应一个开放字体文件
##### `Font.nameToGlyph(String name)`
根据字符名称查找对应的GlyphData

### GlyphData类
一个glyph元素定义了SVG字体中的一个独立的字形。
#### `GlyphData.getPath()`
获取字形的路径数据

### Path类 
字体的路径集合，类似于svg路径集合
##### `Path.toSVG()`
将字体转换成svg文件的XML字符串

##### `Path.toSVG(String filePath)`
将字体数据保存成指定svg文件

## License

MIT
