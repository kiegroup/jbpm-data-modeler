package org.jboss.errai.ioc.client;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.jboss.errai.ioc.client.api.ReplyTo;
import org.jboss.errai.ioc.client.api.ToSubject;
import org.uberfire.client.workbench.annotations.AssociatedResource;
import org.uberfire.client.workbench.annotations.Identifier;
import org.uberfire.client.workbench.annotations.Priority;
import org.uberfire.client.workbench.annotations.WorkbenchPosition;

public class QualifierEqualityFactoryImpl implements QualifierEqualityFactory {
  private HashMap<String, AnnotationComparator> comparatorMap = new HashMap<String, AnnotationComparator>();
  public QualifierEqualityFactoryImpl() {
    comparatorMap.put("org.uberfire.client.workbench.annotations.Priority", new AnnotationComparator<Priority>() {
      @Override public boolean isEqual(Priority a1, Priority a2) {
        if (a1.value() != a2.value()) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(Priority a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.uberfire.client.workbench.annotations.WorkbenchPosition", new AnnotationComparator<WorkbenchPosition>() {
      @Override public boolean isEqual(WorkbenchPosition a1, WorkbenchPosition a2) {
        if (!a1.position().equals(a2.position())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(WorkbenchPosition a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.position());
        return hash;
      }
    });
    comparatorMap.put("org.uberfire.client.workbench.annotations.Identifier", new AnnotationComparator<Identifier>() {
      @Override public boolean isEqual(Identifier a1, Identifier a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(Identifier a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.jboss.errai.ioc.client.api.ToSubject", new AnnotationComparator<ToSubject>() {
      @Override public boolean isEqual(ToSubject a1, ToSubject a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ToSubject a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.jboss.errai.ioc.client.api.ReplyTo", new AnnotationComparator<ReplyTo>() {
      @Override public boolean isEqual(ReplyTo a1, ReplyTo a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(ReplyTo a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
    comparatorMap.put("org.uberfire.client.workbench.annotations.AssociatedResource", new AnnotationComparator<AssociatedResource>() {
      @Override public boolean isEqual(AssociatedResource a1, AssociatedResource a2) {
        if (!a1.value().equals(a2.value())) {
          return false;
        }
        return true;
      }
      public int hashCodeOf(AssociatedResource a1) {
        int hash = a1.annotationType().hashCode();
        hash = (31 * hash) + QualifierUtil.hashValueFor(a1.value());
        return hash;
      }
    });
  }

  public boolean isEqual(Annotation a1, Annotation a2) {
    if (QualifierUtil.isSameType(a1, a2)) {
      if (comparatorMap.containsKey(a1.annotationType().getName())) {
        return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).isEqual(a1, a2);
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

  public int hashCodeOf(Annotation a1) {
    if (comparatorMap.containsKey(a1.annotationType().getName())) {
      return ((AnnotationComparator) comparatorMap.get(a1.annotationType().getName())).hashCodeOf(a1);
    } else {
      return a1.annotationType().hashCode();
    }
  }
}