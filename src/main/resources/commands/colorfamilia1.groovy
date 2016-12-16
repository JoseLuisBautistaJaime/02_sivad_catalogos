package commands

import mx.com.nmp.ms.sivad.catalogo.domain.Color
import mx.com.nmp.ms.sivad.catalogo.service.ColorService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@SuppressWarnings("GroovyUnusedDeclaration")
@Usage("Administración del catálogo Color familia 1")
class colorfamilia1 extends basefamiliascolor<Color> {
    @Usage("""Permite asignar padres a un elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 1, Rol padre: Color""")
    @Command
    def agregarpadres(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviaturas padres. Catálogo Color")
                      @Required @Argument List<String> padres) {
        super.agregarPadres(context, elemento, padres);
    }

    @Usage("""Permite desasignar un padre al elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 1, Rol padre: Color""")
    @Command
    def eliminarpadre(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviatura padre. Catálogo Color")
                      @Required @Argument String padre) {
        super.eliminarPadre(context, elemento, padre);
    }

    @Override
    protected ColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(ColorService.class);
    }

    @Override
    protected String buscarReferencias() {
        return "Familia 2"
    }
}
