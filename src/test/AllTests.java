package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import main.com.neet.DiamondHunter.Main.GamePanel;

@RunWith(Suite.class)
@SuiteClasses({ GamePanel.class, ItemCount.class, TimerTest.class })
public class AllTests {

}
