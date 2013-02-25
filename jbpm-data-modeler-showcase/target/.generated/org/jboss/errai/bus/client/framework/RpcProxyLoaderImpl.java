package org.jboss.errai.bus.client.framework;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.interceptor.RemoteCallContext;
import org.kie.commons.java.nio.file.CopyOption;
import org.kie.commons.java.nio.file.DirectoryStream;
import org.kie.commons.java.nio.file.DirectoryStream.Filter;
import org.kie.commons.java.nio.file.OpenOption;
import org.kie.commons.java.nio.file.Path;
import org.uberfire.backend.FileExplorerRootService;
import org.uberfire.backend.Root;
import org.uberfire.backend.vfs.FileSystem;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.backend.vfs.impl.VFSCacheInterceptor;
import org.uberfire.client.workbench.model.PerspectiveDefinition;
import org.uberfire.client.workbench.services.UserServices;
import org.uberfire.client.workbench.services.WorkbenchServices;

public class RpcProxyLoaderImpl implements RpcProxyLoader {
  public void loadProxies(final MessageBus bus) {
    class org_uberfire_client_workbench_services_WorkbenchServicesImpl implements WorkbenchServices, RpcStub {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      private Annotation[] qualifiers;
      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public void setQualifiers(Annotation[] quals) {
        qualifiers = quals;
      }

      public void save(final PerspectiveDefinition a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.client.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.client.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public PerspectiveDefinition load(final String a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("load:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("load:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public Map loadDefaultEditorsMap() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public void saveDefaultEditors(final Map a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public boolean equals(final Object a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public String toString() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public int hashCode() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.WorkbenchServices").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(WorkbenchServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_client_workbench_services_WorkbenchServicesImpl();
      }
    });
    class org_uberfire_client_workbench_services_UserServicesImpl implements UserServices, RpcStub {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      private Annotation[] qualifiers;
      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public void setQualifiers(Annotation[] quals) {
        qualifiers = quals;
      }

      public Path buildPath(final String a0, final String a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("buildPath:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("buildPath:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public boolean equals(final Object a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public String toString() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public int hashCode() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.client.workbench.services.UserServices").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(UserServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_client_workbench_services_UserServicesImpl();
      }
    });
    class org_uberfire_backend_vfs_VFSServiceImpl implements VFSService, RpcStub {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      private Annotation[] qualifiers;
      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public void setQualifiers(Annotation[] quals) {
        qualifiers = quals;
      }

      public org.uberfire.backend.vfs.Path get(final String a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public DirectoryStream newDirectoryStream(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public DirectoryStream newDirectoryStream(final org.uberfire.backend.vfs.Path a0, final Filter a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path createDirectory(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path createDirectory(final org.uberfire.backend.vfs.Path a0, final Map a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path createDirectories(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path createDirectories(final org.uberfire.backend.vfs.Path a0, final Map a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public Map readAttributes(final org.uberfire.backend.vfs.Path a0) {
        try {
          final CallContextStatus status = new CallContextStatus(VFSCacheInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "readAttributes";
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() != null) {
                if (status.getNextInterceptor() == VFSCacheInterceptor.class) {
                  status.setProceeding(false);
                  new VFSCacheInterceptor().aroundInvoke(this);
                  if (!status.isProceeding()) {
                    remoteCallback.callback(getResult());
                  }
                }
              } else {
                if (errorCallback == null) {
                  MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
                } else {
                  MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
                }
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Message message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  providedErrorCallback.error(message, throwable);
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { a0 });
          callContext.proceed();
        } catch (Throwable throwable) {
          errorCallback.error(null, throwable);
        }
        return null;
      }

      public void setAttributes(final org.uberfire.backend.vfs.Path a0, final Map a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public void delete(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public boolean deleteIfExists(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public org.uberfire.backend.vfs.Path copy(final org.uberfire.backend.vfs.Path a0, final org.uberfire.backend.vfs.Path a1, final CopyOption[] a2) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.CopyOption[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.CopyOption[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path move(final org.uberfire.backend.vfs.Path a0, final org.uberfire.backend.vfs.Path a1, final CopyOption[] a2) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.CopyOption[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:org.kie.commons.java.nio.file.CopyOption[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public String readAllString(final org.uberfire.backend.vfs.Path a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path write(final org.uberfire.backend.vfs.Path a0, final String a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public org.uberfire.backend.vfs.Path write(final org.uberfire.backend.vfs.Path a0, final String a1, final Map a2, final OpenOption[] a3) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:org.kie.commons.java.nio.file.OpenOption[]:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:org.kie.commons.java.nio.file.OpenOption[]:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(org.uberfire.backend.vfs.Path.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public FileSystem newFileSystem(final String a0, final Map a1) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newFileSystem:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FileSystem.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newFileSystem:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FileSystem.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public boolean equals(final Object a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public String toString() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public int hashCode() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VFSService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_vfs_VFSServiceImpl();
      }
    });
    class org_uberfire_backend_FileExplorerRootServiceImpl implements FileExplorerRootService, RpcStub {
      private RemoteCallback remoteCallback;
      private ErrorCallback errorCallback;
      private Annotation[] qualifiers;
      public void setErrorCallback(ErrorCallback callback) {
        errorCallback = callback;
      }

      public void setRemoteCallback(RemoteCallback callback) {
        remoteCallback = callback;
      }

      public void setQualifiers(Annotation[] quals) {
        qualifiers = quals;
      }

      public Collection listRoots() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("listRoots:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("listRoots:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public void addRoot(final Root a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("addRoot:org.uberfire.backend.Root:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("addRoot:org.uberfire.backend.Root:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public void removeRoot(final Root a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("removeRoot:org.uberfire.backend.Root:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("removeRoot:org.uberfire.backend.Root:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public void clear() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("clear:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("clear:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
      }

      public boolean equals(final Object a0) {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("equals:java.lang.Object:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return false;
      }

      public String toString() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("toString:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return null;
      }

      public int hashCode() {
        if (errorCallback == null) {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).defaultErrorHandling().sendNowWith(bus);
        } else {
          MessageBuilder.createCall().call("org.uberfire.backend.FileExplorerRootService").endpoint("hashCode:", qualifiers, new Object[] { }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback).sendNowWith(bus);
        }
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FileExplorerRootService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_FileExplorerRootServiceImpl();
      }
    });
  }
}