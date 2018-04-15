package test

import main.com.neet.DiamondHunter.TileMap.TileMap

Feature: TileLoad

	Scenario: Loading the map

		TileMap tileMap
		int rows
		int columns
		int tiles
		Given at PlayState
			tileMap = new TileMap(16);
			tileMap = new TileMap(16);
			tileMap.loadTiles("/Tilesets/testtileset.gif");
			tileMap.loadMap("/Maps/testmap.map");
		When tile size is 16
			rows = tileMap.getNumRows()
			columns = tileMap.getNumCols()
			tiles = rows * columns
		Then there should be 1600 tiles
			tiles => 1600
		