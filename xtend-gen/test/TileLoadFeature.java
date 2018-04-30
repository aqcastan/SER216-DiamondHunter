package test;

import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import test.TileLoadFeatureLoadingTheMap;

@Contains(TileLoadFeatureLoadingTheMap.class)
@Named("TileLoad")
@RunWith(FeatureRunner.class)
@SuppressWarnings("all")
public class TileLoadFeature {
}
