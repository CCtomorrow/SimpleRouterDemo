package com.ai.router.compiler.util;

import com.ai.router.anno.Route;
import com.ai.router.compiler.Constants;

import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class Utils {

    public static boolean checkTypeValid(Element type) {
        if (type.getKind() != ElementKind.CLASS) {
            error(type, "Only classes can be annotated with @%s.", Route.class.getSimpleName());
            return false;
        }
        TypeElement element = (TypeElement) type;
        Set<Modifier> modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE)) {
            error(element, "The class %s should not be modified by private", element.getSimpleName());
            return false;
        } else if (modifiers.contains(Modifier.ABSTRACT)) {
            return false;
        } else if (!isSuperClass(element, Constants.CLASSNAME_ACTIVITY)) {
            error(element, "The class %s you annotated by %s should be a subclass of Activity",
                    element.getSimpleName(), Route.class.getSimpleName());
            return false;
        }
        return true;
    }

    private static void error(Element element, String message, Object... args) {
        if (args.length > 0) {
            message = String.format(message, args);
        }
        UtilManager.getMgr().getMessager().printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    public static boolean isSuperClass(TypeElement type, String superClass) {
        return !(type == null || "java.lang.Object".equals(type.getQualifiedName().toString()))
                && (type.getQualifiedName().toString().equals(superClass)
                || isSuperClass((TypeElement) UtilManager.getMgr().getTypeUtils().asElement(type.getSuperclass()), superClass));
    }

    public static boolean isEmpty(String data) {
        return data == null || data.length() <= 0;
    }

}
