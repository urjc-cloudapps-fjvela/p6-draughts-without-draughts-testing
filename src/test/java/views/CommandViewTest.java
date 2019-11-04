package views;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.PlayController;
import models.Color;
import models.Coordinate;
import models.Error;
import utils.Console;



@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CommandView commandView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenPlayControllerThenPiecesMoveCorrectly(){
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(console.readString("Mueven las blancas: ")).thenReturn("21.30");
        commandView.interact();
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));

    }

    @Test
    public void givenPlayControllerWhenInvalidCoordinateThenShowErrorOutCoordinate() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(playController.move(new Coordinate(2,1), new Coordinate(-3, 0))).thenReturn(Error.OUT_COORDINATE);

        when(console.readString("Mueven las blancas: "))
            .thenReturn("21.-30")
            .thenReturn("21.30");
        commandView.interact();
        verify(console, atLeast(1)).write("Error!!!" +  Error.OUT_COORDINATE.name());
    }

    @Test(expected = java.lang.NumberFormatException.class)
    public void givenPlayControllerWhenInvalidTextIsWrittenThenShowErrorOutCoordinate() {
        when(playController.getColor()).thenReturn(Color.WHITE);
        when(playController.move(new Coordinate(2,1), new Coordinate(-3, 0))).thenReturn(Error.OUT_COORDINATE);

        when(console.readString("Mueven las blancas: "))
            .thenReturn("ey! show me the error .!")
            .thenReturn("21.30");
        commandView.interact();
        verify(console, atLeast(1)).write("Error!!!" +  Error.INVALID_COORDINATES.name());
    }

}