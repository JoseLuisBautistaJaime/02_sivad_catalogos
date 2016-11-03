package commands

import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor
import mx.com.nmp.ms.sivad.catalogo.service.GrupoColorService
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@Usage("Administra los elementos del catálogo Color familia 3")
class colorfamilia3 extends basefamiliascolor<GrupoColor> {
    @Override
    protected GrupoColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(GrupoColorService)
    }
}