# Java Benchmark Sample 소스코드 정리
> 자바 벤치마킹 테크닉은 두고두고 매우 유용한 자료. 코드량도 매우 적고 보이는 즉시 학습코드로 보관하자

## Article
* [Iteration vs. Recursion in Java - DZone Java](https://dzone.com/articles/iteration-vs-recursion-in-java?edition=385212)
  * Fork from : https://github.com/smartinrub/java-iterative-benchmark
  * [![asciicast](https://asciinema.org/a/190681.png)](https://asciinema.org/a/190681)
  * CLI Commands
    > gradle shadowJar
    >
    > java -jar ./build/libs/benchmark-modules/dzone-interation-recursion-all.jar org.smartinrub.javaiterativebenchmark.BenchMark
  
## Related Link 
* [org.openjdk.jmh 관련해서 상당히 많은 모듈](https://mvnrepository.com/artifact/org.openjdk.jmh)들이 존재한다.
* [Microbenchmarks with JMH / Java Microbenchmark Harness](https://www.hascode.com/2017/10/microbenchmarks-with-jmh-java-microbenchmark-harness/)
