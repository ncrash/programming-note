# Diagrams

https://diagrams.mingrammer.com/

## 개요

- python 코드로 다이어그램 작성

- python 코드를 실행해 다이어그램 렌더링

```shell
poetry run python example_.py
```

- 렌더링 파일명은 name 속성에 지정된 이름으로 자동 생성됨
  - python : `example_advanced_web_service_with_on-premise_(colored).py` 
  - png : `advanced_web_service_with_on-premise_(colored).png`

```python
from diagrams import Cluster, Diagram, Edge

with Diagram(name="Advanced Web Service with On-Premise (colored)", show=False):
```

