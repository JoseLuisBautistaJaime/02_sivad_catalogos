package commands

import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor
import mx.com.nmp.ms.sivad.catalogo.service.EscalaColorService
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@Usage("Administra los elementos del catálogo Color familia 2")
class colorfamilia2 extends basefamiliascolor<EscalaColor> {
    @Override
    protected EscalaColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(EscalaColorService)
    }
}