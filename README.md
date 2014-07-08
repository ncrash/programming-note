#summary project setting에 대한 wiki 페이지

= Introduction =

source code를 checkout 받아서 test 돌리는 방법 정리


== Eclipse ==

 * install
  * Eclipse Galileo SR-1 설치
  * http://ncrash.rollinglist.com/list/view.do?listId=30935&updDate=1257904136000 페이지에서 Subversive, m2eclipse 설치
 * source checkout
  * Eclipse -> Window -> Open Perspective -> SVN Repository Exploring
  * svn repository 등록 - http://java-code-practice-with-tdd.googlecode.com/svn/
   * 등록시 계정정보 필요없음
  * trunk/java-code-practice-with-tdd 디렉토리 checkout
 * maven project setting
  * java perspective open
  * project 명칭위로 커서 이동 후 마우스 오른쪽 버튼 클릭하여 컨텍스트 메뉴 호출
   * Maven -> Enable Dependency Management
  * .classpath
   {{{
	<classpathentry kind="con" path="org.maven.ide.eclipse.MAVEN2_CLASSPATH_CONTAINER">
		<attributes>
			<attribute name="org.eclipse.jst.component.dependency" value="/WEB-INF/lib"/>
		</attributes>
	</classpathentry>
}}}

 * wtp project setting
  * j2ee perspective open
  * project properties open
   * Project Facets -> Dynamic Web Module 2.4 선택
    * Ok 셋팅 적용하면 web content directory 물어봄
    * src\main\webapp