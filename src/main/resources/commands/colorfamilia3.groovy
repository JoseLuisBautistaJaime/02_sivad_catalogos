package commands

import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor
import mx.com.nmp.ms.sivad.catalogo.service.GrupoColorService
import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Required
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@SuppressWarnings("GroovyUnusedDeclaration")
@Usage("Administra los elementos del catálogo Color familia 3")
class colorfamilia3 extends basefamiliascolor<GrupoColor> {
    @Usage("""Permite asignar padres a un elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 3, Rol padre: Color familia 2""")
    @Command
    def agregarpadres(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviaturas padres. Catálogo Color familia 2")
                      @Required @Argument List<String> padres) {
        super.agregarPadres(context, elemento, padres);
    }

    @Usage("""Permite desasignar un padre al elemento del catálogo.
                    Detalle de relación. Rol hijo: Color familia 3, Rol padre: Color familia 2""")
    @Command
    def eliminarpadre(InvocationContext context,
                      @Usage("Abreviatura elemento")
                      @Required @Option(names = ["e", "elemento"]) String elemento,
                      @Usage("Abreviatura padre. Catálogo Color familia 2")
                      @Required @Argument String padre) {
        super.eliminarPadre(context, elemento, padre);
    }

    @Override
    protected GrupoColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(GrupoColorService)
    }

    @Override
    protected String buscarReferencias() {
        return ""
    }
}
