package test;

import main.com.neet.DiamondHunter.TileMap.TileMap;
import org.jnario.lib.Assert;
import org.jnario.lib.Should;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import test.TileLoadFeature;

@RunWith(FeatureRunner.class)
@Named("Scenario: Loading the map")
@SuppressWarnings("all")
public class TileLoadFeatureLoadingTheMap extends TileLoadFeature {
  TileMap tileMap;
  
  int rows;
  
  int columns;
  
  int tiles;
  
  @Test
  @Order(0)
  @Named("Given at PlayState")
  public void _givenAtPlayState() {
    TileMap _tileMap = new TileMap(16);
    this.tileMap = _tileMap;
    TileMap _tileMap_1 = new TileMap(16);
    this.tileMap = _tileMap_1;
    this.tileMap.loadTiles("/Tilesets/testtileset.gif");
    this.tileMap.loadMap("/Maps/testmap.map");
  }
  
  @Test
  @Order(1)
  @Named("When tile size is 16")
  public void _whenTileSizeIs16() {
    int _numRows = this.tileMap.getNumRows();
    this.rows = _numRows;
    int _numCols = this.tileMap.getNumCols();
    this.columns = _numCols;
    this.tiles = (this.rows * this.columns);
  }
  
  @Test
  @Order(2)
  @Named("Then there should be 1600 tiles")
  public void _thenThereShouldBe1600Tiles() {
    Assert.assertTrue("\nExpected tiles => 1600 but"
     + "\n     tiles is " + new org.hamcrest.StringDescription().appendValue(Integer.valueOf(this.tiles)).toString() + "\n", Should.<Integer>operator_doubleArrow(Integer.valueOf(this.tiles), Integer.valueOf(1600)));
    
  }
}
