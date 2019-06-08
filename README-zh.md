# opentype4j
开放字体文件JAVA解析库

API
===
### 加载字体文件
```java
Font font = OpenType.parse(filePath);
System.out.println(font.getPath("you are right").toSVG())
```

### Font类
一个Font类对应一个开放字体文件
##### `Font.getPath(String text)`
获取指定文本的字形的默认的路径数据。默认情况下，一行最大排列16个字符，每个字符尺寸为44*40

##### `Font.getPath()`
获取所有的字形顺序排列的默认路径数据

##### `Font.nameToGlyph(String name)`
根据字符名称查找对应的GlyphData

### GlyphData类
一个glyph元素定义了SVG字体中的一个独立的字形。
#### `GlyphData.getPath()`
获取字形的路径数据，以便后续处理。默认尺寸为44*40。
#### `GlyphData.getPath(FontCell fontCell)`
按照指定的尺寸获取字形的路径数据

* `fontCell`: 定义了要渲染的字体外边界，包括边界尺寸，上下左右内边距大小


### Path类 
字体的路径集合，类似于svg路径集合
##### `Path.toSVG()`
将字体转换成svg文件的XML字符串

##### `Path.toSVG(String filePath)`
将字体数据保存成指定svg文件

##### `Path.toImage(File file)`
将字体数据保存成JPEG格式图片

##### `Path.toImage(File file, ImageFormat format)`
将字体数据保存成指定格式的图片
目前支持的格式有JPEG和PNG

##### `Path.toImageBytes()`
将字体数据转换成JPEG图片的字节数组

##### `Path.toImageBytes(ImageFormat format)`
将字体数据转换成指定格式的图片的字节数组

## License

MIT
