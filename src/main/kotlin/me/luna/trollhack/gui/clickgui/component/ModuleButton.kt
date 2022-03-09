package me.luna.trollhack.gui.clickgui.component

import me.luna.trollhack.gui.clickgui.TrollClickGui
import me.luna.trollhack.gui.rgui.component.BooleanSlider
import me.luna.trollhack.module.AbstractModule
import me.luna.trollhack.util.math.vector.Vec2f

class ModuleButton(val module: AbstractModule) : BooleanSlider(module.name, 0.0f, module.description) {
    init {
        if (module.isEnabled) value = 1.0f
    }

    override fun onTick() {
        super.onTick()
        value = if (module.isEnabled) 1.0f else 0.0f
    }

    override fun onClick(mousePos: Vec2f, buttonId: Int) {
        super.onClick(mousePos, buttonId)
        if (buttonId == 0) module.toggle()
    }

    override fun onRelease(mousePos: Vec2f, buttonId: Int) {
        super.onRelease(mousePos, buttonId)
        if (buttonId == 1) TrollClickGui.displaySettingWindow(module)
    }
}