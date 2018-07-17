# Handlebars.java

fork from : https://github.com/jknack/handlebars.java/tree/v1.3.0

## The Handlebars.java Server

Usage: `java -jar handlebars-proto-${current-version}.jar -dir myTemplates`

### Usage - Example
```
cd /Users/coupang/Code/code-test-practice-by-tdd/web-modules/handlebars/src/main/resources 
java -jar /Users/coupang/.gradle/caches/modules-2/files-2.1/com.github.jknack/handlebars-proto/1.3.0/5810f78798a19fa40dea73fefb09630cc2c41f44/handlebars-proto-1.3.0.jar -dir myTemplates
curl http://localhost:6780/home.hbs
```
```
java -jar /Users/coupang/.gradle/caches/modules-2/files-2.1/com.github.jknack/handlebars-proto/1.3.0/5810f78798a19fa40dea73fefb09630cc2c41f44/handlebars-proto-1.3.0.jar -dir reusing/partials
java -jar /Users/coupang/.gradle/caches/modules-2/files-2.1/com.github.jknack/handlebars-proto/1.3.0/5810f78798a19fa40dea73fefb09630cc2c41f44/handlebars-proto-1.3.0.jar -dir reusing/template-inheritance
java -jar /Users/coupang/.gradle/caches/modules-2/files-2.1/com.github.jknack/handlebars-proto/1.3.0/5810f78798a19fa40dea73fefb09630cc2c41f44/handlebars-proto-1.3.0.jar -dir reusing/embedded
```