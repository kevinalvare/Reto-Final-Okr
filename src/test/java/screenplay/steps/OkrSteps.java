package screenplay.steps;

import com.co.sofka.api.model.Page;
import com.co.sofka.api.model.user.User;
import com.co.sofka.api.tasks.GetOkr;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;

public class OkrSteps {

    Actor actor = Actor.named("kevin");
    EnvironmentVariables variables;

    @Before
    public void setup(){
        actor.whoCan(CallAnApi.at(variables.getProperty("baseurl")));
    }

    @Cuando("consulte todos los usuarios con sus OKRS")
    public void consulteTodosLosUsuariosConSusOKRS() {
        actor.attemptsTo(GetOkr.withResource(variables.getProperty("pathUser")));

    }

    @Entonces("puede recuperar la informacion de los usuarios con sus OKRS correctamente")
    public void puedeRecuperarLaInformacionDeLosUsuariosConSusOKRSCorrectamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        Page page = SerenityRest.lastResponse()
                .jsonPath().getObject("", Page.class);
        assertThat(page).hasNoNullFieldsOrProperties();
        User[] users = SerenityRest.lastResponse()
                .jsonPath().getObject("okrs", User[].class);
        for (int i = 0; i < users.length; i++) {
            assertThat(users[i]).hasNoNullFieldsOrProperties();
        }
    }

    @Cuando("consulte el ultimo okr creado por un usuario")
    public void consulteElUltimoOkrCreadoPorUnUsuario() {
    }

    @Entonces("podre recuperar la información del ultimo okr creado por el usuario")
    public void podreRecuperarLaInformaciónDelUltimoOkrCreadoPorElUsuario() {
    }
}
