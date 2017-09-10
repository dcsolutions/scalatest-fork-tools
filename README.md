# Extra utilities for scalatest suite-sequentiual forking

This project contains a single class which is used to test if a class is an instance of `org.scalatest.Suite`.  

Build:

    git clone ...
    cd scalatest-fork-tools
    mvn clean install

Usage:

    <dependency>
        <groupId>org.scalatest</groupId>
        <artifactId>scalatest_2.12</artifactId>
        <version>3.0.3</version>
        <scope>test</scope>
    </dependency>
    
    <dependency>
        <groupId>com.diehl</groupId>
        <artifactId>scalatest-fork-tools</artifactId>
        <version>1.0.0-SNAPSHOT</version>
        <scope>test</scope>
    </dependency>

From the command line:

    CLASSPATH=... java com.diehl.scalatest.forkTools.IsClassATestSuite /path/to/maven/target/test-classes/directory/ fully.qualified.ClassName

This command is built and executed by the ScalaTest `suite-sequential` `forkMode`.
