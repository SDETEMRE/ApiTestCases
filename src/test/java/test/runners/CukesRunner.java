package test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "test/step_definitions",
        plugin = {"pretty","json:target/cucumber.json",
                "html:target/default-html-reports", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "rerun:target/rerun.txt"},
        publish = true,
        dryRun = false,
        tags = "@apiTest"

)
public class CukesRunner {
}

