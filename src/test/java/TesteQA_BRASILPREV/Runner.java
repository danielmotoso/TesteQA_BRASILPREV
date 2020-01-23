package TesteQA_BRASILPREV;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java",
        strict = false,
        monochrome = true,
        dryRun = false)
public class Runner {

}
