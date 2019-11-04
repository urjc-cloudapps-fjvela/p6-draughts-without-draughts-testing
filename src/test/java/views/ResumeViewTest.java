package views;

import static org.junit.Assert.assertTrue;
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

import utils.Console;


@RunWith(MockitoJUnitRunner.class)
public class ResumeViewTest {

    @Mock
    Console console;

    @InjectMocks
    ResumeView resumeView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeViewWhenAskNewGameThenReturnTrue() {
        when(console.readChar("¿Queréis jugar otra? (s/n): ")).thenReturn('s');
        assertTrue(resumeView.askNewGame());
    }

    @Test
    public void givenResumeViewWhenAskNewGameWithInvalidAnswerThenCheckErrorIsShow() {
        when(console.readChar("¿Queréis jugar otra? (s/n): ")).thenReturn('a').thenReturn('s');
        resumeView.askNewGame();
        verify(console, atLeast(1)).writeln("Escribe s or n");
    }
}