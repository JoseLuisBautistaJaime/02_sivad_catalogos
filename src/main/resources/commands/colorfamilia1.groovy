package commands

import mx.com.nmp.ms.sivad.catalogo.domain.Color
import mx.com.nmp.ms.sivad.catalogo.service.ColorService
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

@Usage("Administra los elementos del catálogo Color familia 1")
class colorfamilia1 extends basefamiliascolor<Color> {
    @Override
    protected ColorService getServicio(InvocationContext context) {
        context.attributes['spring.beanfactory'].getBean(ColorService)
    }
}