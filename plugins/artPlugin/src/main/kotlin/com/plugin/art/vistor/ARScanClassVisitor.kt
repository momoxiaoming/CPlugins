package com.plugin.art.vistor

import com.plugin.art.utils.ScanUtil
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

/**
 * ARScanClassVisitor
 *
 * @author mmxm
 * @date 2022/6/1 11:45
 */
class ARScanClassVisitor(cw: ClassWriter): ClassVisitor(Opcodes.ASM6, cw) {

    override fun visit(
        version: Int,
        access: Int,
        name: String?,
        signature: String?,
        superName: String?,
        interfaces: Array<out String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        ScanUtil.addRoutesList(name)
    }
}