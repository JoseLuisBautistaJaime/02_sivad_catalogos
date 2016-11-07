package commands

import mx.com.nmp.ms.sivad.catalogo.domain.Color
import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException
import mx.com.nmp.ms.sivad.catalogo.service.EscalaColorService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@Usage("Administra los elementos del catálogo Color familia 2")
class colorfamilia2 extends basefamiliascolor<EscalaColor> {
    @Usage("""Permite asignar padres a un elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 2, Rol padre: Color familia 1""")
    @Command
    def agregarpadres(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviaturas padres. Catálogo Color familia 1")
                      @Required @Argument List<String> padres) {
        super.agregarPadres(context, elemento, padres);
    }

    @Usage("""Permite desasignar un padre al elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 2, Rol padre: Color familia 1""")
    @Command
    def eliminarpadre(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviatura padre. Catálogo Color familia 1")
                      @Required @Argument String padre) {
        super.eliminarPadre(context, elemento, padre);
    }

    @Override
    protected EscalaColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(EscalaColorService)
    }

    @Override
    protected String buscarReferencias() {
        return "Familia 3"
    }
}
