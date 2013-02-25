package org.jboss.errai.ioc.client;

import com.allen_sauer.gwt.dnd.client.AbstractDragController;
import com.allen_sauer.gwt.dnd.client.DragController;
import com.allen_sauer.gwt.dnd.client.FiresDragEvents;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.HasDragEndHandlers;
import com.google.gwt.event.dom.client.HasDragEnterHandlers;
import com.google.gwt.event.dom.client.HasDragHandlers;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDragStartHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.HasGestureChangeHandlers;
import com.google.gwt.event.dom.client.HasGestureEndHandlers;
import com.google.gwt.event.dom.client.HasGestureStartHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.HasTouchCancelHandlers;
import com.google.gwt.event.dom.client.HasTouchEndHandlers;
import com.google.gwt.event.dom.client.HasTouchMoveHandlers;
import com.google.gwt.event.dom.client.HasTouchStartHandlers;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.logical.shared.HasCloseHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.AutoDirectionHandler.Target;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.EventPreview;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasAnimation;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasFocus;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HasWidgets.ForIsWidget;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.SourcesFocusEvents;
import com.google.gwt.user.client.ui.SourcesKeyboardEvents;
import com.google.gwt.user.client.ui.SourcesMouseEvents;
import com.google.gwt.user.client.ui.SourcesPopupEvents;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import org.jboss.errai.bus.client.ErraiBus;
import org.jboss.errai.bus.client.framework.MessageBus;
import org.jboss.errai.bus.client.framework.Subscription;
import org.jboss.errai.common.client.api.extension.InitVotes;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.DestructionCallback;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ioc.client.container.ProxyResolver;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.shared.ElementWrapperWidget;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;
import org.jbpm.datamodeler.client.ShowcaseEntryPoint;
import org.jbpm.datamodeler.client.perspectives.HomePerspective;
import org.jbpm.datamodeler.client.perspectives.HomePerspectiveActivity;
import org.jbpm.datamodeler.editor.client.editors.DataModelBrowser;
import org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenter;
import org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenter.DataModelEditorView;
import org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenterActivity;
import org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl;
import org.jbpm.datamodeler.editor.client.editors.DataObjectEditor;
import org.jbpm.datamodeler.editor.client.editors.PropertyEditor;
import org.uberfire.backend.FileExplorerRootService;
import org.uberfire.backend.Root;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.client.CommonsEntryPoint;
import org.uberfire.client.CoreEntryPoint;
import org.uberfire.client.WorkbenchEntryPoint;
import org.uberfire.client.common.MultiPageEditor;
import org.uberfire.client.common.MultiPageEditorView;
import org.uberfire.client.context.DefaultWorkbenchContext;
import org.uberfire.client.context.WorkbenchContext;
import org.uberfire.client.editors.defaulteditor.DefaultFileEditorPresenter;
import org.uberfire.client.editors.defaulteditor.DefaultFileEditorPresenterActivity;
import org.uberfire.client.editors.fileexplorer.FileExplorerPresenter;
import org.uberfire.client.editors.fileexplorer.FileExplorerPresenterActivity;
import org.uberfire.client.editors.fileexplorer.FileExplorerView;
import org.uberfire.client.editors.metafile.MetaFileEditorPresenter;
import org.uberfire.client.editors.metafile.MetaFileEditorPresenterActivity;
import org.uberfire.client.editors.repository.clone.CloneRepositoryForm;
import org.uberfire.client.editors.repository.create.CreateRepositoryForm;
import org.uberfire.client.editors.repository.edit.RepositoryEditorPresenter;
import org.uberfire.client.editors.repository.edit.RepositoryEditorPresenterActivity;
import org.uberfire.client.editors.repository.edit.RepositoryEditorView;
import org.uberfire.client.editors.repository.list.RepositoriesPresenter;
import org.uberfire.client.editors.repository.list.RepositoriesPresenterActivity;
import org.uberfire.client.editors.repository.list.RepositoriesView;
import org.uberfire.client.editors.texteditor.TextEditorPresenter;
import org.uberfire.client.editors.texteditor.TextEditorPresenterActivity;
import org.uberfire.client.editors.texteditor.TextEditorView;
import org.uberfire.client.editors.texteditor.TextResourceType;
import org.uberfire.client.markdown.MarkdownTextContent;
import org.uberfire.client.markdown.MarkdownUtil;
import org.uberfire.client.markdown.editorlive.MarkdownLiveEditorPresenter;
import org.uberfire.client.markdown.editorlive.MarkdownLiveEditorPresenterActivity;
import org.uberfire.client.markdown.editorlive.MarkdownLiveEditorView;
import org.uberfire.client.markdown.editorlive.MarkdownLivePresenter;
import org.uberfire.client.markdown.editorlive.MarkdownLivePresenterActivity;
import org.uberfire.client.markdown.editorlive.MarkdownLiveView;
import org.uberfire.client.markdown.viewer.MarkdownPresenter;
import org.uberfire.client.markdown.viewer.MarkdownPresenterActivity;
import org.uberfire.client.markdown.viewer.MarkdownType;
import org.uberfire.client.markdown.viewer.MarkdownView;
import org.uberfire.client.mvp.AbstractActivity;
import org.uberfire.client.mvp.AbstractPopupActivity;
import org.uberfire.client.mvp.AbstractWorkbenchActivity;
import org.uberfire.client.mvp.AbstractWorkbenchEditorActivity;
import org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity;
import org.uberfire.client.mvp.AbstractWorkbenchScreenActivity;
import org.uberfire.client.mvp.Activity;
import org.uberfire.client.mvp.ActivityBeansCache;
import org.uberfire.client.mvp.ActivityManager;
import org.uberfire.client.mvp.ActivityManagerImpl;
import org.uberfire.client.mvp.DefaultPlaceResolver;
import org.uberfire.client.mvp.PerspectiveActivity;
import org.uberfire.client.mvp.PlaceHistoryHandler;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.PlaceManagerImpl;
import org.uberfire.client.mvp.PlaceRequestHistoryMapper;
import org.uberfire.client.mvp.PlaceRequestHistoryMapperImpl;
import org.uberfire.client.mvp.PopupActivity;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.mvp.WorkbenchActivity;
import org.uberfire.client.mvp.WorkbenchEditorActivity;
import org.uberfire.client.mvp.WorkbenchScreenActivity;
import org.uberfire.client.workbench.BeanFactory;
import org.uberfire.client.workbench.DefaultBeanFactory;
import org.uberfire.client.workbench.Position;
import org.uberfire.client.workbench.ResourceTypeManagerImpl;
import org.uberfire.client.workbench.Workbench;
import org.uberfire.client.workbench.annotations.AssociatedResource;
import org.uberfire.client.workbench.annotations.Identifier;
import org.uberfire.client.workbench.annotations.Priority;
import org.uberfire.client.workbench.annotations.RootWorkbenchPanel;
import org.uberfire.client.workbench.annotations.WorkbenchPosition;
import org.uberfire.client.workbench.file.AnyResourceType;
import org.uberfire.client.workbench.file.DotResourceType;
import org.uberfire.client.workbench.file.ResourceType;
import org.uberfire.client.workbench.file.ResourceTypeManager;
import org.uberfire.client.workbench.services.WorkbenchServices;
import org.uberfire.client.workbench.widgets.dnd.CompassDropController;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchDragContext;
import org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController;
import org.uberfire.client.workbench.widgets.events.BeforeClosePlaceEvent;
import org.uberfire.client.workbench.widgets.events.ChangeTitleWidgetEvent;
import org.uberfire.client.workbench.widgets.events.ClosePlaceEvent;
import org.uberfire.client.workbench.widgets.events.DropPlaceEvent;
import org.uberfire.client.workbench.widgets.events.MaximizePlaceEvent;
import org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent;
import org.uberfire.client.workbench.widgets.events.NotificationEvent;
import org.uberfire.client.workbench.widgets.events.PathChangeEvent;
import org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent;
import org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent;
import org.uberfire.client.workbench.widgets.events.ResourceAddedEvent;
import org.uberfire.client.workbench.widgets.events.ResourceCopiedEvent;
import org.uberfire.client.workbench.widgets.events.ResourceDeletedEvent;
import org.uberfire.client.workbench.widgets.events.ResourceRenamedEvent;
import org.uberfire.client.workbench.widgets.events.RestorePlaceEvent;
import org.uberfire.client.workbench.widgets.events.SavePlaceEvent;
import org.uberfire.client.workbench.widgets.events.SelectPlaceEvent;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBar;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenterUtils;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarView;
import org.uberfire.client.workbench.widgets.notifications.NotificationPopupView;
import org.uberfire.client.workbench.widgets.notifications.NotificationPopupsManager;
import org.uberfire.client.workbench.widgets.panels.HorizontalSplitterPanel;
import org.uberfire.client.workbench.widgets.panels.PanelHelper;
import org.uberfire.client.workbench.widgets.panels.PanelHelperEast;
import org.uberfire.client.workbench.widgets.panels.PanelHelperNorth;
import org.uberfire.client.workbench.widgets.panels.PanelHelperSouth;
import org.uberfire.client.workbench.widgets.panels.PanelHelperWest;
import org.uberfire.client.workbench.widgets.panels.PanelManager;
import org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelPresenter;
import org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView;
import org.uberfire.client.workbench.widgets.panels.SplitPanel;
import org.uberfire.client.workbench.widgets.panels.VerticalSplitterPanel;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPanelPresenter;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPanelView;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPartPresenter;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPartPresenter.View;
import org.uberfire.client.workbench.widgets.panels.WorkbenchPartView;
import org.uberfire.client.workbench.widgets.popup.PopupView;
import org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter;
import org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenterActivity;
import org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundView;
import org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter;
import org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenterActivity;
import org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundView;
import org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter;
import org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarView;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenterUtils;
import org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarView;
import org.uberfire.security.Identity;
import org.uberfire.security.Resource;
import org.uberfire.security.authz.AuthorizationManager;
import org.uberfire.security.authz.RuntimeResource;
import org.uberfire.security.client.SecurityEntryPoint;
import org.uberfire.security.impl.authz.RuntimeAuthorizationManager;

public class BootstrapperImpl implements Bootstrapper {
  {
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.BeforeClosePlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.PathChangeEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ResourceDeletedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ResourceRenamedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.markdown.MarkdownTextContent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.SavePlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.backend.Root", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ChangeTitleWidgetEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.NotificationEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.DropPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.SelectPlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ResourceAddedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ResourceCopiedEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.RestorePlaceEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", "java.lang.Object");
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
  }
  private final Default _1998831462Default_1437020412 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Any _1998831462Any_1400970322 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1909101200 = new Annotation[] { _1998831462Default_1437020412, _1998831462Any_1400970322 };
  private final Priority _$1620005882Priority__811849969 = new Priority() {
    public Class annotationType() {
      return Priority.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Priority(value=-2147483648)";
    }
    public int value() {
      return -2147483648;
    }
  };
  private final AssociatedResource _$1620005882AssociatedResource_591678011 = new AssociatedResource() {
    public Class annotationType() {
      return AssociatedResource.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.AssociatedResource(value=class org.uberfire.client.workbench.file.AnyResourceType)";
    }
    public Class value() {
      return AnyResourceType.class;
    }
  };
  private final Identifier _$1620005882Identifier_530443269 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=DefaultFileEditor)";
    }
    public String value() {
      return "DefaultFileEditor";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1810418547 = new Annotation[] { _$1620005882Priority__811849969, _$1620005882AssociatedResource_591678011, _$1620005882Identifier_530443269, _1998831462Any_1400970322 };
  private final Priority _$1620005882Priority_1335633679 = new Priority() {
    public Class annotationType() {
      return Priority.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Priority(value=0)";
    }
    public int value() {
      return 0;
    }
  };
  private final Identifier _$1620005882Identifier_69672718 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=MarkdownViewer)";
    }
    public String value() {
      return "MarkdownViewer";
    }
  };
  private final AssociatedResource _$1620005882AssociatedResource_851244157 = new AssociatedResource() {
    public Class annotationType() {
      return AssociatedResource.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.AssociatedResource(value=class org.uberfire.client.markdown.viewer.MarkdownType)";
    }
    public Class value() {
      return MarkdownType.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_596385935 = new Annotation[] { _$1620005882Priority_1335633679, _$1620005882Identifier_69672718, _$1620005882AssociatedResource_851244157, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier_77721332 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=FileExplorer)";
    }
    public String value() {
      return "FileExplorer";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_46006661 = new Annotation[] { _$1620005882Identifier_77721332, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier__693552614 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=RepositoriesEditor)";
    }
    public String value() {
      return "RepositoriesEditor";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1824450930 = new Annotation[] { _$1620005882Identifier__693552614, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier_2141530744 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=RepositoryEditor)";
    }
    public String value() {
      return "RepositoryEditor";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1009268860 = new Annotation[] { _$1620005882Identifier_2141530744, _$1620005882Priority_1335633679, _1998831462Any_1400970322 };
  private final WorkbenchPosition _$1620005882WorkbenchPosition_2140478101 = new WorkbenchPosition() {
    public Class annotationType() {
      return WorkbenchPosition.class;
    }
    public Position position() {
      return Position.NORTH;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.WorkbenchPosition(position=NORTH)";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_304328246 = new Annotation[] { _$1620005882WorkbenchPosition_2140478101, _1998831462Any_1400970322 };
  private final WorkbenchPosition _$1620005882WorkbenchPosition_13456063 = new WorkbenchPosition() {
    public Class annotationType() {
      return WorkbenchPosition.class;
    }
    public Position position() {
      return Position.SOUTH;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.WorkbenchPosition(position=SOUTH)";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_798604784 = new Annotation[] { _$1620005882WorkbenchPosition_13456063, _1998831462Any_1400970322 };
  private final WorkbenchPosition _$1620005882WorkbenchPosition_772071556 = new WorkbenchPosition() {
    public Class annotationType() {
      return WorkbenchPosition.class;
    }
    public Position position() {
      return Position.EAST;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.WorkbenchPosition(position=EAST)";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_259448057 = new Annotation[] { _$1620005882WorkbenchPosition_772071556, _1998831462Any_1400970322 };
  private final WorkbenchPosition _$1620005882WorkbenchPosition_762108414 = new WorkbenchPosition() {
    public Class annotationType() {
      return WorkbenchPosition.class;
    }
    public Position position() {
      return Position.WEST;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.WorkbenchPosition(position=WEST)";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1508307357 = new Annotation[] { _$1620005882WorkbenchPosition_762108414, _1998831462Any_1400970322 };
  private final RootWorkbenchPanel _$1620005882RootWorkbenchPanel_0 = new RootWorkbenchPanel() {
    public Class annotationType() {
      return RootWorkbenchPanel.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.RootWorkbenchPanel()";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1626376289 = new Annotation[] { _$1620005882RootWorkbenchPanel_0, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier_1697911629 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=workbench.activities.multiple)";
    }
    public String value() {
      return "workbench.activities.multiple";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1374778235 = new Annotation[] { _$1620005882Identifier_1697911629, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier__2081030635 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=TextEditor)";
    }
    public String value() {
      return "TextEditor";
    }
  };
  private final AssociatedResource _$1620005882AssociatedResource_1152199569 = new AssociatedResource() {
    public Class annotationType() {
      return AssociatedResource.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.AssociatedResource(value=class org.uberfire.client.editors.texteditor.TextResourceType)";
    }
    public Class value() {
      return TextResourceType.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1544573185 = new Annotation[] { _$1620005882Identifier__2081030635, _$1620005882Priority_1335633679, _$1620005882AssociatedResource_1152199569, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier_952104167 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=MarkdownLiveEditor)";
    }
    public String value() {
      return "MarkdownLiveEditor";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1967159266 = new Annotation[] { _$1620005882Identifier_952104167, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier_962616530 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=homePerspective)";
    }
    public String value() {
      return "homePerspective";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1623288266 = new Annotation[] { _$1620005882Identifier_962616530, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier__1755709245 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=DataModelEditor)";
    }
    public String value() {
      return "DataModelEditor";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_224919741 = new Annotation[] { _1998831462Any_1400970322, _$1620005882Identifier__1755709245 };
  private final Identifier _$1620005882Identifier_1701556496 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=workbench.activity.notfound)";
    }
    public String value() {
      return "workbench.activity.notfound";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_918196602 = new Annotation[] { _$1620005882Identifier_1701556496, _1998831462Any_1400970322 };
  private final Identifier _$1620005882Identifier__628723180 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=MetaFileTextEditor)";
    }
    public String value() {
      return "MetaFileTextEditor";
    }
  };
  private final AssociatedResource _$1620005882AssociatedResource_1966933847 = new AssociatedResource() {
    public Class annotationType() {
      return AssociatedResource.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.AssociatedResource(value=class org.uberfire.client.workbench.file.DotResourceType)";
    }
    public Class value() {
      return DotResourceType.class;
    }
  };
  private final Priority _$1620005882Priority_811849876 = new Priority() {
    public Class annotationType() {
      return Priority.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Priority(value=2147483547)";
    }
    public int value() {
      return 2147483547;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_882894192 = new Annotation[] { _$1620005882Identifier__628723180, _1998831462Any_1400970322, _$1620005882Priority_811849876, _$1620005882AssociatedResource_1966933847 };
  private final Identifier _$1620005882Identifier__604585086 = new Identifier() {
    public Class annotationType() {
      return Identifier.class;
    }
    public String toString() {
      return "@org.uberfire.client.workbench.annotations.Identifier(value=MarkdownLiveViewer)";
    }
    public String value() {
      return "MarkdownLiveViewer";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1920101153 = new Annotation[] { _$1620005882Identifier__604585086, _1998831462Any_1400970322 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DefaultWorkbenchContext> inj2257_DefaultWorkbenchContext_creational = new CreationalCallback<DefaultWorkbenchContext>() {
    public DefaultWorkbenchContext getInstance(final CreationalContext context) {
      final DefaultWorkbenchContext inj2256_DefaultWorkbenchContext = new DefaultWorkbenchContext();
      context.addBean(context.getBeanReference(DefaultWorkbenchContext.class, arrayOf_19635043Annotation_1909101200), inj2256_DefaultWorkbenchContext);
      final Subscription var1 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PathChangeEvent", new AbstractCDIEventCallback<PathChangeEvent>() {
        public void fireEvent(final PathChangeEvent event) {
          inj2256_DefaultWorkbenchContext.setActivePath(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PathChangeEvent []";
        }
      });
      context.addDestructionCallback(inj2256_DefaultWorkbenchContext, new DestructionCallback<DefaultWorkbenchContext>() {
        public void destroy(final DefaultWorkbenchContext obj) {
          var1.remove();
        }
      });
      return inj2256_DefaultWorkbenchContext;
    }
  };
  private final DefaultWorkbenchContext inj2256_DefaultWorkbenchContext = inj2257_DefaultWorkbenchContext_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj2258_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj2241_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_1909101200), inj2241_IOCBeanManagerProvider);
      return inj2241_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj2241_IOCBeanManagerProvider = inj2258_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<WorkbenchPickupDragController> inj2260_WorkbenchPickupDragController_creational = new CreationalCallback<WorkbenchPickupDragController>() {
    public WorkbenchPickupDragController getInstance(final CreationalContext context) {
      final WorkbenchPickupDragController inj2259_WorkbenchPickupDragController = new WorkbenchPickupDragController();
      context.addBean(context.getBeanReference(WorkbenchPickupDragController.class, arrayOf_19635043Annotation_1909101200), inj2259_WorkbenchPickupDragController);
      final WorkbenchDragAndDropManager_inj2261_proxy inj2261_proxy = new WorkbenchDragAndDropManager_inj2261_proxy();
      context.addUnresolvedProxy(new ProxyResolver<WorkbenchDragAndDropManager>() {
        public void resolve(WorkbenchDragAndDropManager obj) {
          inj2261_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj2261_proxy, obj);
        }
      }, WorkbenchDragAndDropManager.class, arrayOf_19635043Annotation_1909101200);
      _683332058_dndManager(inj2259_WorkbenchPickupDragController, inj2261_proxy);
      return inj2259_WorkbenchPickupDragController;
    }
  };
  private final WorkbenchPickupDragController inj2259_WorkbenchPickupDragController = inj2260_WorkbenchPickupDragController_creational.getInstance(context);
  private final CreationalCallback<DefaultBeanFactory> inj2263_DefaultBeanFactory_creational = new CreationalCallback<DefaultBeanFactory>() {
    public DefaultBeanFactory getInstance(final CreationalContext context) {
      final DefaultBeanFactory inj2262_DefaultBeanFactory = new DefaultBeanFactory();
      context.addBean(context.getBeanReference(DefaultBeanFactory.class, arrayOf_19635043Annotation_1909101200), inj2262_DefaultBeanFactory);
      _1174169399_iocManager(inj2262_DefaultBeanFactory, inj2241_IOCBeanManagerProvider.get());
      return inj2262_DefaultBeanFactory;
    }
  };
  private final DefaultBeanFactory inj2262_DefaultBeanFactory = inj2263_DefaultBeanFactory_creational.getInstance(context);
  private final CreationalCallback<WorkbenchDragAndDropManager> inj2265_WorkbenchDragAndDropManager_creational = new CreationalCallback<WorkbenchDragAndDropManager>() {
    public WorkbenchDragAndDropManager getInstance(final CreationalContext context) {
      final WorkbenchDragAndDropManager inj2264_WorkbenchDragAndDropManager = new WorkbenchDragAndDropManager();
      context.addBean(context.getBeanReference(WorkbenchDragAndDropManager.class, arrayOf_19635043Annotation_1909101200), inj2264_WorkbenchDragAndDropManager);
      _153624969_dragController(inj2264_WorkbenchDragAndDropManager, context.getInstanceOrNew(inj2260_WorkbenchPickupDragController_creational, WorkbenchPickupDragController.class, arrayOf_19635043Annotation_1909101200));
      _153624969_factory(inj2264_WorkbenchDragAndDropManager, inj2262_DefaultBeanFactory);
      return inj2264_WorkbenchDragAndDropManager;
    }
  };
  private final WorkbenchDragAndDropManager inj2264_WorkbenchDragAndDropManager = inj2265_WorkbenchDragAndDropManager_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj2266_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj2249_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_1909101200), inj2249_EventProvider);
      return inj2249_EventProvider;
    }
  };
  private final EventProvider inj2249_EventProvider = inj2266_EventProvider_creational.getInstance(context);
  private final CreationalCallback<WorkbenchStatusBarView> inj2269_WorkbenchStatusBarView_creational = new CreationalCallback<WorkbenchStatusBarView>() {
    public WorkbenchStatusBarView getInstance(final CreationalContext context) {
      final WorkbenchStatusBarView inj2049_WorkbenchStatusBarView = new WorkbenchStatusBarView();
      context.addBean(context.getBeanReference(WorkbenchStatusBarView.class, arrayOf_19635043Annotation_1909101200), inj2049_WorkbenchStatusBarView);
      return inj2049_WorkbenchStatusBarView;
    }
  };
  private InitializationCallback<WorkbenchStatusBarPresenter> init_inj2267_WorkbenchStatusBarPresenter = new InitializationCallback<WorkbenchStatusBarPresenter>() {
    public void init(final WorkbenchStatusBarPresenter obj) {
      _$18744388_init(obj);
    }
  };
  private final CreationalCallback<WorkbenchStatusBarPresenter> inj2268_WorkbenchStatusBarPresenter_creational = new CreationalCallback<WorkbenchStatusBarPresenter>() {
    public WorkbenchStatusBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchStatusBarPresenter inj2267_WorkbenchStatusBarPresenter = new WorkbenchStatusBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchStatusBarPresenter.class, arrayOf_19635043Annotation_1909101200), inj2267_WorkbenchStatusBarPresenter);
      _$18744388_view(inj2267_WorkbenchStatusBarPresenter, inj2269_WorkbenchStatusBarView_creational.getInstance(context));
      _$18744388_restorePlaceEvent(inj2267_WorkbenchStatusBarPresenter, inj2249_EventProvider.provide(new Class[] { RestorePlaceEvent.class }, null));
      final Subscription var2 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent", new AbstractCDIEventCallback<MinimizePlaceEvent>() {
        public void fireEvent(final MinimizePlaceEvent event) {
          inj2267_WorkbenchStatusBarPresenter.panelMinimized(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2267_WorkbenchStatusBarPresenter, new DestructionCallback<WorkbenchStatusBarPresenter>() {
        public void destroy(final WorkbenchStatusBarPresenter obj) {
          var2.remove();
        }
      });
      final Subscription var3 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.RestorePlaceEvent", new AbstractCDIEventCallback<RestorePlaceEvent>() {
        public void fireEvent(final RestorePlaceEvent event) {
          inj2267_WorkbenchStatusBarPresenter.partRestored(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.RestorePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2267_WorkbenchStatusBarPresenter, new DestructionCallback<WorkbenchStatusBarPresenter>() {
        public void destroy(final WorkbenchStatusBarPresenter obj) {
          var3.remove();
        }
      });
      final Subscription var4 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$18744388_onWorkbenchPartClose(inj2267_WorkbenchStatusBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2267_WorkbenchStatusBarPresenter, new DestructionCallback<WorkbenchStatusBarPresenter>() {
        public void destroy(final WorkbenchStatusBarPresenter obj) {
          var4.remove();
        }
      });
      context.addInitializationCallback(inj2267_WorkbenchStatusBarPresenter, init_inj2267_WorkbenchStatusBarPresenter);
      return inj2267_WorkbenchStatusBarPresenter;
    }
  };
  private final WorkbenchStatusBarPresenter inj2267_WorkbenchStatusBarPresenter = inj2268_WorkbenchStatusBarPresenter_creational.getInstance(context);
  private final CreationalCallback<PanelManager> inj2271_PanelManager_creational = new CreationalCallback<PanelManager>() {
    public PanelManager getInstance(final CreationalContext context) {
      final PanelManager inj2270_PanelManager = new PanelManager();
      context.addBean(context.getBeanReference(PanelManager.class, arrayOf_19635043Annotation_1909101200), inj2270_PanelManager);
      _$76429077_factory(inj2270_PanelManager, inj2262_DefaultBeanFactory);
      _$76429077_beforeClosePlaceEvent(inj2270_PanelManager, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$76429077_placeGainFocusEvent(inj2270_PanelManager, inj2249_EventProvider.provide(new Class[] { PlaceGainFocusEvent.class }, null));
      _$76429077_placeLostFocusEvent(inj2270_PanelManager, inj2249_EventProvider.provide(new Class[] { PlaceLostFocusEvent.class }, null));
      _$76429077_selectPlaceEvent(inj2270_PanelManager, inj2249_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null));
      _$76429077_statusBar(inj2270_PanelManager, inj2267_WorkbenchStatusBarPresenter);
      final Subscription var5 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.SelectPlaceEvent", new AbstractCDIEventCallback<SelectPlaceEvent>() {
        public void fireEvent(final SelectPlaceEvent event) {
          _$76429077_onSelectPlaceEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.SelectPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var5.remove();
        }
      });
      final Subscription var6 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$76429077_onClosePlaceEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var6.remove();
        }
      });
      final Subscription var7 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.DropPlaceEvent", new AbstractCDIEventCallback<DropPlaceEvent>() {
        public void fireEvent(final DropPlaceEvent event) {
          _$76429077_onDropPlaceEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.DropPlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var7.remove();
        }
      });
      final Subscription var8 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent", new AbstractCDIEventCallback<MinimizePlaceEvent>() {
        public void fireEvent(final MinimizePlaceEvent event) {
          _$76429077_onMinimizePlaceEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.MinimizePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var8.remove();
        }
      });
      final Subscription var9 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.RestorePlaceEvent", new AbstractCDIEventCallback<RestorePlaceEvent>() {
        public void fireEvent(final RestorePlaceEvent event) {
          _$76429077_onRestorePlaceEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.RestorePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var9.remove();
        }
      });
      final Subscription var10 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ChangeTitleWidgetEvent", new AbstractCDIEventCallback<ChangeTitleWidgetEvent>() {
        public void fireEvent(final ChangeTitleWidgetEvent event) {
          _$76429077_onChangeTitleWidgetEvent(inj2270_PanelManager, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ChangeTitleWidgetEvent []";
        }
      });
      context.addDestructionCallback(inj2270_PanelManager, new DestructionCallback<PanelManager>() {
        public void destroy(final PanelManager obj) {
          var10.remove();
        }
      });
      return inj2270_PanelManager;
    }
  };
  private final PanelManager inj2270_PanelManager = inj2271_PanelManager_creational.getInstance(context);
  private final CreationalCallback<CompassDropController> inj2273_CompassDropController_creational = new CreationalCallback<CompassDropController>() {
    public CompassDropController getInstance(final CreationalContext context) {
      final CompassDropController inj2272_CompassDropController = new CompassDropController();
      context.addBean(context.getBeanReference(CompassDropController.class, arrayOf_19635043Annotation_1909101200), inj2272_CompassDropController);
      _$1705636724_panelManager(inj2272_CompassDropController, inj2270_PanelManager);
      _$1705636724_dndManager(inj2272_CompassDropController, inj2264_WorkbenchDragAndDropManager);
      _$1705636724_workbenchPartDroppedEvent(inj2272_CompassDropController, inj2249_EventProvider.provide(new Class[] { DropPlaceEvent.class }, null));
      return inj2272_CompassDropController;
    }
  };
  private final CreationalCallback<CallerProvider> inj2274_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj2251_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_1909101200), inj2251_CallerProvider);
      return inj2251_CallerProvider;
    }
  };
  private final CallerProvider inj2251_CallerProvider = inj2274_CallerProvider_creational.getInstance(context);
  private InitializationCallback<TextEditorView> init_inj1878_TextEditorView = new InitializationCallback<TextEditorView>() {
    public void init(final TextEditorView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<TextEditorView> inj2277_TextEditorView_creational = new CreationalCallback<TextEditorView>() {
    public TextEditorView getInstance(final CreationalContext context) {
      final TextEditorView inj1878_TextEditorView = new TextEditorView();
      context.addBean(context.getBeanReference(TextEditorView.class, arrayOf_19635043Annotation_1909101200), inj1878_TextEditorView);
      context.addInitializationCallback(inj1878_TextEditorView, init_inj1878_TextEditorView);
      return inj1878_TextEditorView;
    }
  };
  private final CreationalCallback<DefaultFileEditorPresenter> inj2276_DefaultFileEditorPresenter_creational = new CreationalCallback<DefaultFileEditorPresenter>() {
    public DefaultFileEditorPresenter getInstance(final CreationalContext context) {
      final DefaultFileEditorPresenter inj2275_DefaultFileEditorPresenter = new DefaultFileEditorPresenter();
      context.addBean(context.getBeanReference(DefaultFileEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2275_DefaultFileEditorPresenter);
      inj2275_DefaultFileEditorPresenter.view = inj2277_TextEditorView_creational.getInstance(context);
      _$1988003627_vfsServices(inj2275_DefaultFileEditorPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj2275_DefaultFileEditorPresenter;
    }
  };
  private final CreationalCallback<MessageBusProvider> inj2278_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj2235_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_1909101200), inj2235_MessageBusProvider);
      return inj2235_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj2235_MessageBusProvider = inj2278_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<SecurityEntryPoint> inj2280_SecurityEntryPoint_creational = new CreationalCallback<SecurityEntryPoint>() {
    public SecurityEntryPoint getInstance(final CreationalContext context) {
      final SecurityEntryPoint inj2279_SecurityEntryPoint = new SecurityEntryPoint();
      context.addBean(context.getBeanReference(SecurityEntryPoint.class, arrayOf_19635043Annotation_1909101200), inj2279_SecurityEntryPoint);
      _1135152903_bus(inj2279_SecurityEntryPoint, inj2235_MessageBusProvider.get());
      return inj2279_SecurityEntryPoint;
    }
  };
  private final SecurityEntryPoint inj2279_SecurityEntryPoint = inj2280_SecurityEntryPoint_creational.getInstance(context);
  private InitializationCallback<ActivityBeansCache> init_inj2281_ActivityBeansCache = new InitializationCallback<ActivityBeansCache>() {
    public void init(final ActivityBeansCache obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ActivityBeansCache> inj2282_ActivityBeansCache_creational = new CreationalCallback<ActivityBeansCache>() {
    public ActivityBeansCache getInstance(final CreationalContext context) {
      final IOCBeanManager var12 = inj2241_IOCBeanManagerProvider.get();
      final ActivityBeansCache inj2281_ActivityBeansCache = new ActivityBeansCache(var12);
      context.addBean(context.getBeanReference(ActivityBeansCache.class, arrayOf_19635043Annotation_1909101200), inj2281_ActivityBeansCache);
      context.addInitializationCallback(inj2281_ActivityBeansCache, init_inj2281_ActivityBeansCache);
      return inj2281_ActivityBeansCache;
    }
  };
  private final ActivityBeansCache inj2281_ActivityBeansCache = inj2282_ActivityBeansCache_creational.getInstance(context);
  private final CreationalCallback<RuntimeAuthorizationManager> inj2284_RuntimeAuthorizationManager_creational = new CreationalCallback<RuntimeAuthorizationManager>() {
    public RuntimeAuthorizationManager getInstance(final CreationalContext context) {
      final RuntimeAuthorizationManager inj2283_RuntimeAuthorizationManager = new RuntimeAuthorizationManager();
      context.addBean(context.getBeanReference(RuntimeAuthorizationManager.class, arrayOf_19635043Annotation_1909101200), inj2283_RuntimeAuthorizationManager);
      return inj2283_RuntimeAuthorizationManager;
    }
  };
  private final RuntimeAuthorizationManager inj2283_RuntimeAuthorizationManager = inj2284_RuntimeAuthorizationManager_creational.getInstance(context);
  private final CreationalCallback<ActivityManagerImpl> inj2286_ActivityManagerImpl_creational = new CreationalCallback<ActivityManagerImpl>() {
    public ActivityManagerImpl getInstance(final CreationalContext context) {
      final ActivityManagerImpl inj2285_ActivityManagerImpl = new ActivityManagerImpl();
      context.addBean(context.getBeanReference(ActivityManagerImpl.class, arrayOf_19635043Annotation_1909101200), inj2285_ActivityManagerImpl);
      _1730935432_iocManager(inj2285_ActivityManagerImpl, inj2241_IOCBeanManagerProvider.get());
      _1730935432_authzManager(inj2285_ActivityManagerImpl, inj2283_RuntimeAuthorizationManager);
      _1730935432_activityBeansCache(inj2285_ActivityManagerImpl, inj2281_ActivityBeansCache);
      final CreationalCallback<Identity> var13 = new CreationalCallback<Identity>() {
        public Identity getInstance(CreationalContext pContext) {
          Identity var13 = inj2279_SecurityEntryPoint.currentUser();
          context.addBean(context.getBeanReference(Identity.class, arrayOf_19635043Annotation_1909101200), var13);
          return var13;
        }
      };
      _1730935432_identity(inj2285_ActivityManagerImpl, context.getSingletonInstanceOrNew(injContext, var13, Identity.class, arrayOf_19635043Annotation_1909101200));
      return inj2285_ActivityManagerImpl;
    }
  };
  private final ActivityManagerImpl inj2285_ActivityManagerImpl = inj2286_ActivityManagerImpl_creational.getInstance(context);
  private final CreationalCallback<PlaceRequestHistoryMapperImpl> inj2289_PlaceRequestHistoryMapperImpl_creational = new CreationalCallback<PlaceRequestHistoryMapperImpl>() {
    public PlaceRequestHistoryMapperImpl getInstance(final CreationalContext context) {
      final PlaceRequestHistoryMapperImpl inj82_PlaceRequestHistoryMapperImpl = new PlaceRequestHistoryMapperImpl();
      context.addBean(context.getBeanReference(PlaceRequestHistoryMapperImpl.class, arrayOf_19635043Annotation_1909101200), inj82_PlaceRequestHistoryMapperImpl);
      return inj82_PlaceRequestHistoryMapperImpl;
    }
  };
  private final CreationalCallback<PlaceHistoryHandler> inj2288_PlaceHistoryHandler_creational = new CreationalCallback<PlaceHistoryHandler>() {
    public PlaceHistoryHandler getInstance(final CreationalContext context) {
      final PlaceHistoryHandler inj2287_PlaceHistoryHandler = new PlaceHistoryHandler();
      context.addBean(context.getBeanReference(PlaceHistoryHandler.class, arrayOf_19635043Annotation_1909101200), inj2287_PlaceHistoryHandler);
      _1047951015_mapper(inj2287_PlaceHistoryHandler, inj2289_PlaceRequestHistoryMapperImpl_creational.getInstance(context));
      return inj2287_PlaceHistoryHandler;
    }
  };
  private final CreationalCallback<DefaultPlaceResolver> inj2291_DefaultPlaceResolver_creational = new CreationalCallback<DefaultPlaceResolver>() {
    public DefaultPlaceResolver getInstance(final CreationalContext context) {
      final DefaultPlaceResolver inj2290_DefaultPlaceResolver = new DefaultPlaceResolver();
      context.addBean(context.getBeanReference(DefaultPlaceResolver.class, arrayOf_19635043Annotation_1909101200), inj2290_DefaultPlaceResolver);
      _$1022831358_wbServices(inj2290_DefaultPlaceResolver, inj2251_CallerProvider.provide(new Class[] { WorkbenchServices.class }, null));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2290_DefaultPlaceResolver.init();
        }
      });
      return inj2290_DefaultPlaceResolver;
    }
  };
  private final DefaultPlaceResolver inj2290_DefaultPlaceResolver = inj2291_DefaultPlaceResolver_creational.getInstance(context);
  private final CreationalCallback<PlaceManagerImpl> inj2293_PlaceManagerImpl_creational = new CreationalCallback<PlaceManagerImpl>() {
    public PlaceManagerImpl getInstance(final CreationalContext context) {
      final ActivityManager var14 = inj2285_ActivityManagerImpl;
      final PlaceHistoryHandler var15 = inj2288_PlaceHistoryHandler_creational.getInstance(context);
      final Event<SelectPlaceEvent> var16 = inj2249_EventProvider.provide(new Class[] { SelectPlaceEvent.class }, null);
      final PanelManager var17 = inj2270_PanelManager;
      final PlaceManagerImpl inj2292_PlaceManagerImpl = new PlaceManagerImpl(var14, var15, var16, var17);
      context.addBean(context.getBeanReference(PlaceManagerImpl.class, arrayOf_19635043Annotation_1909101200), inj2292_PlaceManagerImpl);
      _$1757102468_workbenchPartBeforeCloseEvent(inj2292_PlaceManagerImpl, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$1757102468_workbenchPartCloseEvent(inj2292_PlaceManagerImpl, inj2249_EventProvider.provide(new Class[] { ClosePlaceEvent.class }, null));
      _$1757102468_workbenchPartLostFocusEvent(inj2292_PlaceManagerImpl, inj2249_EventProvider.provide(new Class[] { PlaceLostFocusEvent.class }, null));
      _$1757102468_defaultPlaceResolver(inj2292_PlaceManagerImpl, inj2290_DefaultPlaceResolver);
      final Subscription var18 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.BeforeClosePlaceEvent", new AbstractCDIEventCallback<BeforeClosePlaceEvent>() {
        public void fireEvent(final BeforeClosePlaceEvent event) {
          _$1757102468_onWorkbenchPartBeforeClose(inj2292_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.BeforeClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2292_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var18.remove();
        }
      });
      final Subscription var19 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$1757102468_onWorkbenchPartClose(inj2292_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2292_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var19.remove();
        }
      });
      final Subscription var20 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$1757102468_onWorkbenchPartOnFocus(inj2292_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2292_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var20.remove();
        }
      });
      final Subscription var21 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          _$1757102468_onWorkbenchPartLostFocus(inj2292_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2292_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var21.remove();
        }
      });
      final Subscription var22 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.SavePlaceEvent", new AbstractCDIEventCallback<SavePlaceEvent>() {
        public void fireEvent(final SavePlaceEvent event) {
          _$1757102468_onSavePlace(inj2292_PlaceManagerImpl, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.SavePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2292_PlaceManagerImpl, new DestructionCallback<PlaceManagerImpl>() {
        public void destroy(final PlaceManagerImpl obj) {
          var22.remove();
        }
      });
      return inj2292_PlaceManagerImpl;
    }
  };
  private final PlaceManagerImpl inj2292_PlaceManagerImpl = inj2293_PlaceManagerImpl_creational.getInstance(context);
  private InitializationCallback<ActivityNotFoundView> init_inj848_ActivityNotFoundView = new InitializationCallback<ActivityNotFoundView>() {
    public void init(final ActivityNotFoundView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ActivityNotFoundView> inj2296_ActivityNotFoundView_creational = new CreationalCallback<ActivityNotFoundView>() {
    public ActivityNotFoundView getInstance(final CreationalContext context) {
      final ActivityNotFoundView inj848_ActivityNotFoundView = new ActivityNotFoundView();
      context.addBean(context.getBeanReference(ActivityNotFoundView.class, arrayOf_19635043Annotation_1909101200), inj848_ActivityNotFoundView);
      context.addInitializationCallback(inj848_ActivityNotFoundView, init_inj848_ActivityNotFoundView);
      return inj848_ActivityNotFoundView;
    }
  };
  private final CreationalCallback<ActivityNotFoundPresenter> inj2295_ActivityNotFoundPresenter_creational = new CreationalCallback<ActivityNotFoundPresenter>() {
    public ActivityNotFoundPresenter getInstance(final CreationalContext context) {
      final ActivityNotFoundPresenter inj2294_ActivityNotFoundPresenter = new ActivityNotFoundPresenter();
      context.addBean(context.getBeanReference(ActivityNotFoundPresenter.class, arrayOf_19635043Annotation_1909101200), inj2294_ActivityNotFoundPresenter);
      _$2051264158_view(inj2294_ActivityNotFoundPresenter, inj2296_ActivityNotFoundView_creational.getInstance(context));
      _$2051264158_placeManager(inj2294_ActivityNotFoundPresenter, inj2292_PlaceManagerImpl);
      _$2051264158_closePlaceEvent(inj2294_ActivityNotFoundPresenter, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      return inj2294_ActivityNotFoundPresenter;
    }
  };
  private final ActivityNotFoundPresenter inj2294_ActivityNotFoundPresenter = inj2295_ActivityNotFoundPresenter_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj2297_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj2255_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_1909101200), inj2255_SenderProvider);
      return inj2255_SenderProvider;
    }
  };
  private final SenderProvider inj2255_SenderProvider = inj2297_SenderProvider_creational.getInstance(context);
  private InitializationCallback<MultipleActivitiesFoundView> init_inj2069_MultipleActivitiesFoundView = new InitializationCallback<MultipleActivitiesFoundView>() {
    public void init(final MultipleActivitiesFoundView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MultipleActivitiesFoundView> inj2300_MultipleActivitiesFoundView_creational = new CreationalCallback<MultipleActivitiesFoundView>() {
    public MultipleActivitiesFoundView getInstance(final CreationalContext context) {
      final MultipleActivitiesFoundView inj2069_MultipleActivitiesFoundView = new MultipleActivitiesFoundView();
      context.addBean(context.getBeanReference(MultipleActivitiesFoundView.class, arrayOf_19635043Annotation_1909101200), inj2069_MultipleActivitiesFoundView);
      context.addInitializationCallback(inj2069_MultipleActivitiesFoundView, init_inj2069_MultipleActivitiesFoundView);
      return inj2069_MultipleActivitiesFoundView;
    }
  };
  private InitializationCallback<MultipleActivitiesFoundPresenter> init_inj2298_MultipleActivitiesFoundPresenter = new InitializationCallback<MultipleActivitiesFoundPresenter>() {
    public void init(final MultipleActivitiesFoundPresenter obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MultipleActivitiesFoundPresenter> inj2299_MultipleActivitiesFoundPresenter_creational = new CreationalCallback<MultipleActivitiesFoundPresenter>() {
    public MultipleActivitiesFoundPresenter getInstance(final CreationalContext context) {
      final MultipleActivitiesFoundPresenter inj2298_MultipleActivitiesFoundPresenter = new MultipleActivitiesFoundPresenter();
      context.addBean(context.getBeanReference(MultipleActivitiesFoundPresenter.class, arrayOf_19635043Annotation_1909101200), inj2298_MultipleActivitiesFoundPresenter);
      _1214998186_view(inj2298_MultipleActivitiesFoundPresenter, inj2300_MultipleActivitiesFoundView_creational.getInstance(context));
      _1214998186_placeManager(inj2298_MultipleActivitiesFoundPresenter, inj2292_PlaceManagerImpl);
      _1214998186_activityManager(inj2298_MultipleActivitiesFoundPresenter, inj2285_ActivityManagerImpl);
      _1214998186_closePlaceEvent(inj2298_MultipleActivitiesFoundPresenter, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _1214998186_defaultPlaceResolver(inj2298_MultipleActivitiesFoundPresenter, inj2290_DefaultPlaceResolver);
      context.addInitializationCallback(inj2298_MultipleActivitiesFoundPresenter, init_inj2298_MultipleActivitiesFoundPresenter);
      return inj2298_MultipleActivitiesFoundPresenter;
    }
  };
  private final MultipleActivitiesFoundPresenter inj2298_MultipleActivitiesFoundPresenter = inj2299_MultipleActivitiesFoundPresenter_creational.getInstance(context);
  private final CreationalCallback<WorkbenchToolBarPresenterUtils> inj2302_WorkbenchToolBarPresenterUtils_creational = new CreationalCallback<WorkbenchToolBarPresenterUtils>() {
    public WorkbenchToolBarPresenterUtils getInstance(final CreationalContext context) {
      final RuntimeAuthorizationManager var23 = inj2283_RuntimeAuthorizationManager;
      final CreationalCallback<Identity> var24 = new CreationalCallback<Identity>() {
        public Identity getInstance(CreationalContext pContext) {
          Identity var24 = inj2279_SecurityEntryPoint.currentUser();
          context.addBean(context.getBeanReference(Identity.class, arrayOf_19635043Annotation_1909101200), var24);
          return var24;
        }
      };
      final Identity var25 = context.getSingletonInstanceOrNew(injContext, var24, Identity.class, arrayOf_19635043Annotation_1909101200);
      final WorkbenchToolBarPresenterUtils inj2301_WorkbenchToolBarPresenterUtils = new WorkbenchToolBarPresenterUtils(var23, var25);
      context.addBean(context.getBeanReference(WorkbenchToolBarPresenterUtils.class, arrayOf_19635043Annotation_1909101200), inj2301_WorkbenchToolBarPresenterUtils);
      return inj2301_WorkbenchToolBarPresenterUtils;
    }
  };
  private final WorkbenchToolBarPresenterUtils inj2301_WorkbenchToolBarPresenterUtils = inj2302_WorkbenchToolBarPresenterUtils_creational.getInstance(context);
  private final CreationalCallback<WorkbenchToolBarView> inj2305_WorkbenchToolBarView_creational = new CreationalCallback<WorkbenchToolBarView>() {
    public WorkbenchToolBarView getInstance(final CreationalContext context) {
      final WorkbenchToolBarView inj451_WorkbenchToolBarView = new WorkbenchToolBarView();
      context.addBean(context.getBeanReference(WorkbenchToolBarView.class, arrayOf_19635043Annotation_1909101200), inj451_WorkbenchToolBarView);
      return inj451_WorkbenchToolBarView;
    }
  };
  private final CreationalCallback<WorkbenchToolBarPresenter> inj2304_WorkbenchToolBarPresenter_creational = new CreationalCallback<WorkbenchToolBarPresenter>() {
    public WorkbenchToolBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchToolBarPresenter inj2303_WorkbenchToolBarPresenter = new WorkbenchToolBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchToolBarPresenter.class, arrayOf_19635043Annotation_1909101200), inj2303_WorkbenchToolBarPresenter);
      _40974972_view(inj2303_WorkbenchToolBarPresenter, inj2305_WorkbenchToolBarView_creational.getInstance(context));
      _40974972_placeManager(inj2303_WorkbenchToolBarPresenter, inj2292_PlaceManagerImpl);
      _40974972_toolBarUtils(inj2303_WorkbenchToolBarPresenter, inj2301_WorkbenchToolBarPresenterUtils);
      final Subscription var26 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _40974972_onWorkbenchPartClose(inj2303_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2303_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var26.remove();
        }
      });
      final Subscription var27 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          _40974972_onWorkbenchPartLostFocus(inj2303_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2303_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var27.remove();
        }
      });
      final Subscription var28 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _40974972_onWorkbenchPartOnFocus(inj2303_WorkbenchToolBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2303_WorkbenchToolBarPresenter, new DestructionCallback<WorkbenchToolBarPresenter>() {
        public void destroy(final WorkbenchToolBarPresenter obj) {
          var28.remove();
        }
      });
      return inj2303_WorkbenchToolBarPresenter;
    }
  };
  private final WorkbenchToolBarPresenter inj2303_WorkbenchToolBarPresenter = inj2304_WorkbenchToolBarPresenter_creational.getInstance(context);
  private final CreationalCallback<WorkbenchMenuBarPresenterUtils> inj2307_WorkbenchMenuBarPresenterUtils_creational = new CreationalCallback<WorkbenchMenuBarPresenterUtils>() {
    public WorkbenchMenuBarPresenterUtils getInstance(final CreationalContext context) {
      final RuntimeAuthorizationManager var29 = inj2283_RuntimeAuthorizationManager;
      final CreationalCallback<Identity> var30 = new CreationalCallback<Identity>() {
        public Identity getInstance(CreationalContext pContext) {
          Identity var30 = inj2279_SecurityEntryPoint.currentUser();
          context.addBean(context.getBeanReference(Identity.class, arrayOf_19635043Annotation_1909101200), var30);
          return var30;
        }
      };
      final Identity var31 = context.getSingletonInstanceOrNew(injContext, var30, Identity.class, arrayOf_19635043Annotation_1909101200);
      final WorkbenchMenuBarPresenterUtils inj2306_WorkbenchMenuBarPresenterUtils = new WorkbenchMenuBarPresenterUtils(var29, var31);
      context.addBean(context.getBeanReference(WorkbenchMenuBarPresenterUtils.class, arrayOf_19635043Annotation_1909101200), inj2306_WorkbenchMenuBarPresenterUtils);
      return inj2306_WorkbenchMenuBarPresenterUtils;
    }
  };
  private final WorkbenchMenuBarPresenterUtils inj2306_WorkbenchMenuBarPresenterUtils = inj2307_WorkbenchMenuBarPresenterUtils_creational.getInstance(context);
  private final CreationalCallback<WorkbenchMenuBarView> inj2310_WorkbenchMenuBarView_creational = new CreationalCallback<WorkbenchMenuBarView>() {
    public WorkbenchMenuBarView getInstance(final CreationalContext context) {
      final WorkbenchMenuBarView inj2169_WorkbenchMenuBarView = new WorkbenchMenuBarView();
      context.addBean(context.getBeanReference(WorkbenchMenuBarView.class, arrayOf_19635043Annotation_1909101200), inj2169_WorkbenchMenuBarView);
      return inj2169_WorkbenchMenuBarView;
    }
  };
  private final CreationalCallback<WorkbenchMenuBarPresenter> inj2309_WorkbenchMenuBarPresenter_creational = new CreationalCallback<WorkbenchMenuBarPresenter>() {
    public WorkbenchMenuBarPresenter getInstance(final CreationalContext context) {
      final WorkbenchMenuBarPresenter inj2308_WorkbenchMenuBarPresenter = new WorkbenchMenuBarPresenter();
      context.addBean(context.getBeanReference(WorkbenchMenuBarPresenter.class, arrayOf_19635043Annotation_1909101200), inj2308_WorkbenchMenuBarPresenter);
      _$292735039_view(inj2308_WorkbenchMenuBarPresenter, inj2310_WorkbenchMenuBarView_creational.getInstance(context));
      _$292735039_placeManager(inj2308_WorkbenchMenuBarPresenter, inj2292_PlaceManagerImpl);
      _$292735039_menuBarUtils(inj2308_WorkbenchMenuBarPresenter, inj2306_WorkbenchMenuBarPresenterUtils);
      final Subscription var32 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$292735039_onWorkbenchPartClose(inj2308_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2308_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var32.remove();
        }
      });
      final Subscription var33 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent", new AbstractCDIEventCallback<PlaceLostFocusEvent>() {
        public void fireEvent(final PlaceLostFocusEvent event) {
          _$292735039_onWorkbenchPartLostFocus(inj2308_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceLostFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2308_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var33.remove();
        }
      });
      final Subscription var34 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent", new AbstractCDIEventCallback<PlaceGainFocusEvent>() {
        public void fireEvent(final PlaceGainFocusEvent event) {
          _$292735039_onWorkbenchPartOnFocus(inj2308_WorkbenchMenuBarPresenter, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.PlaceGainFocusEvent []";
        }
      });
      context.addDestructionCallback(inj2308_WorkbenchMenuBarPresenter, new DestructionCallback<WorkbenchMenuBarPresenter>() {
        public void destroy(final WorkbenchMenuBarPresenter obj) {
          var34.remove();
        }
      });
      return inj2308_WorkbenchMenuBarPresenter;
    }
  };
  private final WorkbenchMenuBarPresenter inj2308_WorkbenchMenuBarPresenter = inj2309_WorkbenchMenuBarPresenter_creational.getInstance(context);
  private InitializationCallback<Workbench> init_inj2311_Workbench = new InitializationCallback<Workbench>() {
    public void init(final Workbench obj) {
      obj.setup();
    }
  };
  private final CreationalCallback<Workbench> inj2312_Workbench_creational = new CreationalCallback<Workbench>() {
    public Workbench getInstance(final CreationalContext context) {
      final Workbench inj2311_Workbench = new Workbench();
      context.addBean(context.getBeanReference(Workbench.class, arrayOf_19635043Annotation_1909101200), inj2311_Workbench);
      _$1462522111_panelManager(inj2311_Workbench, inj2270_PanelManager);
      _$1462522111_iocManager(inj2311_Workbench, inj2241_IOCBeanManagerProvider.get());
      _$1462522111_dndManager(inj2311_Workbench, inj2264_WorkbenchDragAndDropManager);
      _$1462522111_placeManager(inj2311_Workbench, inj2292_PlaceManagerImpl);
      _$1462522111_dragController(inj2311_Workbench, inj2259_WorkbenchPickupDragController);
      _$1462522111_menuBarPresenter(inj2311_Workbench, inj2308_WorkbenchMenuBarPresenter);
      _$1462522111_toolBarPresenter(inj2311_Workbench, inj2303_WorkbenchToolBarPresenter);
      _$1462522111_wbServices(inj2311_Workbench, inj2251_CallerProvider.provide(new Class[] { WorkbenchServices.class }, null));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          _$1462522111_bootstrap(inj2311_Workbench);
        }
      });
      context.addInitializationCallback(inj2311_Workbench, init_inj2311_Workbench);
      return inj2311_Workbench;
    }
  };
  private final Workbench inj2311_Workbench = inj2312_Workbench_creational.getInstance(context);
  private InitializationCallback<WorkbenchEntryPoint> init_inj2313_WorkbenchEntryPoint = new InitializationCallback<WorkbenchEntryPoint>() {
    public void init(final WorkbenchEntryPoint obj) {
      obj.init();
    }
  };
  private final CreationalCallback<WorkbenchEntryPoint> inj2314_WorkbenchEntryPoint_creational = new CreationalCallback<WorkbenchEntryPoint>() {
    public WorkbenchEntryPoint getInstance(final CreationalContext context) {
      final WorkbenchEntryPoint inj2313_WorkbenchEntryPoint = new WorkbenchEntryPoint();
      context.addBean(context.getBeanReference(WorkbenchEntryPoint.class, arrayOf_19635043Annotation_1909101200), inj2313_WorkbenchEntryPoint);
      _1452746254_workbench(inj2313_WorkbenchEntryPoint, inj2311_Workbench);
      _1452746254_pathChangedEvent(inj2313_WorkbenchEntryPoint, inj2249_EventProvider.provide(new Class[] { PathChangeEvent.class }, null));
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2313_WorkbenchEntryPoint.startApp();
        }
      });
      context.addInitializationCallback(inj2313_WorkbenchEntryPoint, init_inj2313_WorkbenchEntryPoint);
      return inj2313_WorkbenchEntryPoint;
    }
  };
  private final WorkbenchEntryPoint inj2313_WorkbenchEntryPoint = inj2314_WorkbenchEntryPoint_creational.getInstance(context);
  private final CreationalCallback<DefaultFileEditorPresenterActivity> inj2316_DefaultFileEditorPresenterActivity_creational = new CreationalCallback<DefaultFileEditorPresenterActivity>() {
    public DefaultFileEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var35 = inj2292_PlaceManagerImpl;
      final DefaultFileEditorPresenterActivity inj2315_DefaultFileEditorPresenterActivity = new DefaultFileEditorPresenterActivity(var35);
      context.addBean(context.getBeanReference(DefaultFileEditorPresenterActivity.class, arrayOf_19635043Annotation_1810418547), inj2315_DefaultFileEditorPresenterActivity);
      _$1969214716_realPresenter(inj2315_DefaultFileEditorPresenterActivity, inj2276_DefaultFileEditorPresenter_creational.getInstance(context));
      return inj2315_DefaultFileEditorPresenterActivity;
    }
  };
  private final CreationalCallback<FileExplorerView> inj2319_FileExplorerView_creational = new CreationalCallback<FileExplorerView>() {
    public FileExplorerView getInstance(final CreationalContext context) {
      final FileExplorerView inj1212_FileExplorerView = new FileExplorerView();
      context.addBean(context.getBeanReference(FileExplorerView.class, arrayOf_19635043Annotation_1909101200), inj1212_FileExplorerView);
      return inj1212_FileExplorerView;
    }
  };
  private InitializationCallback<FileExplorerPresenter> init_inj2317_FileExplorerPresenter = new InitializationCallback<FileExplorerPresenter>() {
    public void init(final FileExplorerPresenter obj) {
      obj.assertActivePath();
    }
  };
  private final CreationalCallback<FileExplorerPresenter> inj2318_FileExplorerPresenter_creational = new CreationalCallback<FileExplorerPresenter>() {
    public FileExplorerPresenter getInstance(final CreationalContext context) {
      final FileExplorerPresenter inj2317_FileExplorerPresenter = new FileExplorerPresenter();
      context.addBean(context.getBeanReference(FileExplorerPresenter.class, arrayOf_19635043Annotation_1909101200), inj2317_FileExplorerPresenter);
      _$1421195439_view(inj2317_FileExplorerPresenter, inj2319_FileExplorerView_creational.getInstance(context));
      _$1421195439_vfsService(inj2317_FileExplorerPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      _$1421195439_rootService(inj2317_FileExplorerPresenter, inj2251_CallerProvider.provide(new Class[] { FileExplorerRootService.class }, null));
      _$1421195439_pathChangedEvent(inj2317_FileExplorerPresenter, inj2249_EventProvider.provide(new Class[] { PathChangeEvent.class }, null));
      _$1421195439_placeManager(inj2317_FileExplorerPresenter, inj2292_PlaceManagerImpl);
      final Subscription var36 = CDI.subscribe("org.uberfire.backend.Root", new AbstractCDIEventCallback<Root>() {
        public void fireEvent(final Root event) {
          inj2317_FileExplorerPresenter.newRootDirectory(event);
        }
        public String toString() {
          return "Observer: org.uberfire.backend.Root []";
        }
      });
      final Subscription var37 = ErraiBus.get().subscribe("cdi.event:org.uberfire.backend.Root", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2317_FileExplorerPresenter, new DestructionCallback<FileExplorerPresenter>() {
        public void destroy(final FileExplorerPresenter obj) {
          var36.remove();
          var37.remove();
        }
      });
      final Subscription var38 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ResourceAddedEvent", new AbstractCDIEventCallback<ResourceAddedEvent>() {
        public void fireEvent(final ResourceAddedEvent event) {
          inj2317_FileExplorerPresenter.onResourceAdded(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ResourceAddedEvent []";
        }
      });
      context.addDestructionCallback(inj2317_FileExplorerPresenter, new DestructionCallback<FileExplorerPresenter>() {
        public void destroy(final FileExplorerPresenter obj) {
          var38.remove();
        }
      });
      final Subscription var39 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ResourceDeletedEvent", new AbstractCDIEventCallback<ResourceDeletedEvent>() {
        public void fireEvent(final ResourceDeletedEvent event) {
          inj2317_FileExplorerPresenter.onResourceDeleted(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ResourceDeletedEvent []";
        }
      });
      context.addDestructionCallback(inj2317_FileExplorerPresenter, new DestructionCallback<FileExplorerPresenter>() {
        public void destroy(final FileExplorerPresenter obj) {
          var39.remove();
        }
      });
      final Subscription var40 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ResourceCopiedEvent", new AbstractCDIEventCallback<ResourceCopiedEvent>() {
        public void fireEvent(final ResourceCopiedEvent event) {
          inj2317_FileExplorerPresenter.onResourceCopied(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ResourceCopiedEvent []";
        }
      });
      context.addDestructionCallback(inj2317_FileExplorerPresenter, new DestructionCallback<FileExplorerPresenter>() {
        public void destroy(final FileExplorerPresenter obj) {
          var40.remove();
        }
      });
      final Subscription var41 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ResourceRenamedEvent", new AbstractCDIEventCallback<ResourceRenamedEvent>() {
        public void fireEvent(final ResourceRenamedEvent event) {
          inj2317_FileExplorerPresenter.onResourceRenamed(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ResourceRenamedEvent []";
        }
      });
      context.addDestructionCallback(inj2317_FileExplorerPresenter, new DestructionCallback<FileExplorerPresenter>() {
        public void destroy(final FileExplorerPresenter obj) {
          var41.remove();
        }
      });
      context.addInitializationCallback(inj2317_FileExplorerPresenter, init_inj2317_FileExplorerPresenter);
      return inj2317_FileExplorerPresenter;
    }
  };
  private final CreationalCallback<ListWidgetProvider> inj2320_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj2233_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_1909101200), inj2233_ListWidgetProvider);
      return inj2233_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj2233_ListWidgetProvider = inj2320_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<NotificationPopupsManager> inj2322_NotificationPopupsManager_creational = new CreationalCallback<NotificationPopupsManager>() {
    public NotificationPopupsManager getInstance(final CreationalContext context) {
      final NotificationPopupsManager inj2321_NotificationPopupsManager = new NotificationPopupsManager();
      context.addBean(context.getBeanReference(NotificationPopupsManager.class, arrayOf_19635043Annotation_1909101200), inj2321_NotificationPopupsManager);
      _$746838216_iocManager(inj2321_NotificationPopupsManager, inj2241_IOCBeanManagerProvider.get());
      final Subscription var42 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.NotificationEvent", new AbstractCDIEventCallback<NotificationEvent>() {
        public void fireEvent(final NotificationEvent event) {
          inj2321_NotificationPopupsManager.addNotification(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.NotificationEvent []";
        }
      });
      context.addDestructionCallback(inj2321_NotificationPopupsManager, new DestructionCallback<NotificationPopupsManager>() {
        public void destroy(final NotificationPopupsManager obj) {
          var42.remove();
        }
      });
      return inj2321_NotificationPopupsManager;
    }
  };
  private final NotificationPopupsManager inj2321_NotificationPopupsManager = inj2322_NotificationPopupsManager_creational.getInstance(context);
  private final CreationalCallback<ShowcaseEntryPoint> inj2324_ShowcaseEntryPoint_creational = new CreationalCallback<ShowcaseEntryPoint>() {
    public ShowcaseEntryPoint getInstance(final CreationalContext context) {
      final ShowcaseEntryPoint inj2323_ShowcaseEntryPoint = new ShowcaseEntryPoint();
      context.addBean(context.getBeanReference(ShowcaseEntryPoint.class, arrayOf_19635043Annotation_1909101200), inj2323_ShowcaseEntryPoint);
      _381543805_manager(inj2323_ShowcaseEntryPoint, inj2241_IOCBeanManagerProvider.get());
      _381543805_menubar(inj2323_ShowcaseEntryPoint, inj2308_WorkbenchMenuBarPresenter);
      _381543805_rootService(inj2323_ShowcaseEntryPoint, inj2251_CallerProvider.provide(new Class[] { FileExplorerRootService.class }, null));
      _381543805_placeManager(inj2323_ShowcaseEntryPoint, inj2292_PlaceManagerImpl);
      _381543805_iocManager(inj2323_ShowcaseEntryPoint, inj2241_IOCBeanManagerProvider.get());
      _381543805_activityManager(inj2323_ShowcaseEntryPoint, inj2285_ActivityManagerImpl);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2323_ShowcaseEntryPoint.startApp();
        }
      });
      return inj2323_ShowcaseEntryPoint;
    }
  };
  private final ShowcaseEntryPoint inj2323_ShowcaseEntryPoint = inj2324_ShowcaseEntryPoint_creational.getInstance(context);
  private final CreationalCallback<DotResourceType> inj2326_DotResourceType_creational = new CreationalCallback<DotResourceType>() {
    public DotResourceType getInstance(final CreationalContext context) {
      final DotResourceType inj2325_DotResourceType = new DotResourceType();
      context.addBean(context.getBeanReference(DotResourceType.class, arrayOf_19635043Annotation_1909101200), inj2325_DotResourceType);
      return inj2325_DotResourceType;
    }
  };
  private final DotResourceType inj2325_DotResourceType = inj2326_DotResourceType_creational.getInstance(context);
  private final CreationalCallback<HomePerspective> inj2328_HomePerspective_creational = new CreationalCallback<HomePerspective>() {
    public HomePerspective getInstance(final CreationalContext context) {
      final HomePerspective inj2327_HomePerspective = new HomePerspective();
      context.addBean(context.getBeanReference(HomePerspective.class, arrayOf_19635043Annotation_1909101200), inj2327_HomePerspective);
      return inj2327_HomePerspective;
    }
  };
  private final HomePerspective inj2327_HomePerspective = inj2328_HomePerspective_creational.getInstance(context);
  private final CreationalCallback<CommonsEntryPoint> inj2330_CommonsEntryPoint_creational = new CreationalCallback<CommonsEntryPoint>() {
    public CommonsEntryPoint getInstance(final CreationalContext context) {
      final CommonsEntryPoint inj2329_CommonsEntryPoint = new CommonsEntryPoint();
      context.addBean(context.getBeanReference(CommonsEntryPoint.class, arrayOf_19635043Annotation_1909101200), inj2329_CommonsEntryPoint);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2329_CommonsEntryPoint.startApp();
        }
      });
      return inj2329_CommonsEntryPoint;
    }
  };
  private final CommonsEntryPoint inj2329_CommonsEntryPoint = inj2330_CommonsEntryPoint_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj2331_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj2245_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_1909101200), inj2245_InstanceProvider);
      return inj2245_InstanceProvider;
    }
  };
  private final InstanceProvider inj2245_InstanceProvider = inj2331_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<MetaFileEditorPresenter> inj2333_MetaFileEditorPresenter_creational = new CreationalCallback<MetaFileEditorPresenter>() {
    public MetaFileEditorPresenter getInstance(final CreationalContext context) {
      final MetaFileEditorPresenter inj2332_MetaFileEditorPresenter = new MetaFileEditorPresenter();
      context.addBean(context.getBeanReference(MetaFileEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2332_MetaFileEditorPresenter);
      inj2332_MetaFileEditorPresenter.view = inj2277_TextEditorView_creational.getInstance(context);
      _$238379932_vfsServices(inj2332_MetaFileEditorPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj2332_MetaFileEditorPresenter;
    }
  };
  private InitializationCallback<MarkdownView> init_inj311_MarkdownView = new InitializationCallback<MarkdownView>() {
    public void init(final MarkdownView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MarkdownView> inj2336_MarkdownView_creational = new CreationalCallback<MarkdownView>() {
    public MarkdownView getInstance(final CreationalContext context) {
      final MarkdownView inj311_MarkdownView = new MarkdownView();
      context.addBean(context.getBeanReference(MarkdownView.class, arrayOf_19635043Annotation_1909101200), inj311_MarkdownView);
      context.addInitializationCallback(inj311_MarkdownView, init_inj311_MarkdownView);
      return inj311_MarkdownView;
    }
  };
  private final CreationalCallback<MarkdownPresenter> inj2335_MarkdownPresenter_creational = new CreationalCallback<MarkdownPresenter>() {
    public MarkdownPresenter getInstance(final CreationalContext context) {
      final MarkdownPresenter inj2334_MarkdownPresenter = new MarkdownPresenter();
      context.addBean(context.getBeanReference(MarkdownPresenter.class, arrayOf_19635043Annotation_1909101200), inj2334_MarkdownPresenter);
      _235547309_vfsServices(inj2334_MarkdownPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      inj2334_MarkdownPresenter.view = inj2336_MarkdownView_creational.getInstance(context);
      return inj2334_MarkdownPresenter;
    }
  };
  private final CreationalCallback<MarkdownPresenterActivity> inj2338_MarkdownPresenterActivity_creational = new CreationalCallback<MarkdownPresenterActivity>() {
    public MarkdownPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var43 = inj2292_PlaceManagerImpl;
      final MarkdownPresenterActivity inj2337_MarkdownPresenterActivity = new MarkdownPresenterActivity(var43);
      context.addBean(context.getBeanReference(MarkdownPresenterActivity.class, arrayOf_19635043Annotation_596385935), inj2337_MarkdownPresenterActivity);
      _1906672860_realPresenter(inj2337_MarkdownPresenterActivity, inj2335_MarkdownPresenter_creational.getInstance(context));
      return inj2337_MarkdownPresenterActivity;
    }
  };
  private InitializationCallback<FileExplorerPresenterActivity> init_inj2339_FileExplorerPresenterActivity = new InitializationCallback<FileExplorerPresenterActivity>() {
    public void init(final FileExplorerPresenterActivity obj) {
      obj.init();
    }
  };
  private final CreationalCallback<FileExplorerPresenterActivity> inj2340_FileExplorerPresenterActivity_creational = new CreationalCallback<FileExplorerPresenterActivity>() {
    public FileExplorerPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var45 = inj2292_PlaceManagerImpl;
      final FileExplorerPresenterActivity inj2339_FileExplorerPresenterActivity = new FileExplorerPresenterActivity(var45);
      context.addBean(context.getBeanReference(FileExplorerPresenterActivity.class, arrayOf_19635043Annotation_46006661), inj2339_FileExplorerPresenterActivity);
      _1189133696_realPresenter(inj2339_FileExplorerPresenterActivity, inj2318_FileExplorerPresenter_creational.getInstance(context));
      context.addInitializationCallback(inj2339_FileExplorerPresenterActivity, init_inj2339_FileExplorerPresenterActivity);
      return inj2339_FileExplorerPresenterActivity;
    }
  };
  private final CreationalCallback<CoreEntryPoint> inj2342_CoreEntryPoint_creational = new CreationalCallback<CoreEntryPoint>() {
    public CoreEntryPoint getInstance(final CreationalContext context) {
      final CoreEntryPoint inj2341_CoreEntryPoint = new CoreEntryPoint();
      context.addBean(context.getBeanReference(CoreEntryPoint.class, arrayOf_19635043Annotation_1909101200), inj2341_CoreEntryPoint);
      InitVotes.registerOneTimeInitCallback(new Runnable() {
        public void run() {
          inj2341_CoreEntryPoint.startApp();
        }
      });
      return inj2341_CoreEntryPoint;
    }
  };
  private final CoreEntryPoint inj2341_CoreEntryPoint = inj2342_CoreEntryPoint_creational.getInstance(context);
  private final CreationalCallback<AnyResourceType> inj2344_AnyResourceType_creational = new CreationalCallback<AnyResourceType>() {
    public AnyResourceType getInstance(final CreationalContext context) {
      final AnyResourceType inj2343_AnyResourceType = new AnyResourceType();
      context.addBean(context.getBeanReference(AnyResourceType.class, arrayOf_19635043Annotation_1909101200), inj2343_AnyResourceType);
      return inj2343_AnyResourceType;
    }
  };
  private final AnyResourceType inj2343_AnyResourceType = inj2344_AnyResourceType_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj2345_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj2253_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_1909101200), inj2253_DisposerProvider);
      _$1300398733_beanManager(inj2253_DisposerProvider, inj2241_IOCBeanManagerProvider.get());
      return inj2253_DisposerProvider;
    }
  };
  private final DisposerProvider inj2253_DisposerProvider = inj2345_DisposerProvider_creational.getInstance(context);
  private InitializationCallback<ResourceTypeManagerImpl> init_inj2346_ResourceTypeManagerImpl = new InitializationCallback<ResourceTypeManagerImpl>() {
    public void init(final ResourceTypeManagerImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ResourceTypeManagerImpl> inj2347_ResourceTypeManagerImpl_creational = new CreationalCallback<ResourceTypeManagerImpl>() {
    public ResourceTypeManagerImpl getInstance(final CreationalContext context) {
      final IOCBeanManager var46 = inj2241_IOCBeanManagerProvider.get();
      final ResourceTypeManagerImpl inj2346_ResourceTypeManagerImpl = new ResourceTypeManagerImpl(var46);
      context.addBean(context.getBeanReference(ResourceTypeManagerImpl.class, arrayOf_19635043Annotation_1909101200), inj2346_ResourceTypeManagerImpl);
      context.addInitializationCallback(inj2346_ResourceTypeManagerImpl, init_inj2346_ResourceTypeManagerImpl);
      return inj2346_ResourceTypeManagerImpl;
    }
  };
  private final ResourceTypeManagerImpl inj2346_ResourceTypeManagerImpl = inj2347_ResourceTypeManagerImpl_creational.getInstance(context);
  private InitializationCallback<RepositoriesView> init_inj882_RepositoriesView = new InitializationCallback<RepositoriesView>() {
    public void init(final RepositoriesView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<RepositoriesView> inj2350_RepositoriesView_creational = new CreationalCallback<RepositoriesView>() {
    public RepositoriesView getInstance(final CreationalContext context) {
      final RepositoriesView inj882_RepositoriesView = new RepositoriesView();
      context.addBean(context.getBeanReference(RepositoriesView.class, arrayOf_19635043Annotation_1909101200), inj882_RepositoriesView);
      context.addInitializationCallback(inj882_RepositoriesView, init_inj882_RepositoriesView);
      return inj882_RepositoriesView;
    }
  };
  private final CreationalCallback<RepositoriesPresenter> inj2349_RepositoriesPresenter_creational = new CreationalCallback<RepositoriesPresenter>() {
    public RepositoriesPresenter getInstance(final CreationalContext context) {
      final RepositoriesPresenter inj2348_RepositoriesPresenter = new RepositoriesPresenter();
      context.addBean(context.getBeanReference(RepositoriesPresenter.class, arrayOf_19635043Annotation_1909101200), inj2348_RepositoriesPresenter);
      _$1729318371_vfsService(inj2348_RepositoriesPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      _$1729318371_rootService(inj2348_RepositoriesPresenter, inj2251_CallerProvider.provide(new Class[] { FileExplorerRootService.class }, null));
      _$1729318371_iocManager(inj2348_RepositoriesPresenter, inj2241_IOCBeanManagerProvider.get());
      inj2348_RepositoriesPresenter.view = inj2350_RepositoriesView_creational.getInstance(context);
      final Subscription var47 = CDI.subscribe("org.uberfire.backend.Root", new AbstractCDIEventCallback<Root>() {
        public void fireEvent(final Root event) {
          inj2348_RepositoriesPresenter.newRootDirectory(event);
        }
        public String toString() {
          return "Observer: org.uberfire.backend.Root []";
        }
      });
      final Subscription var48 = ErraiBus.get().subscribe("cdi.event:org.uberfire.backend.Root", CDI.ROUTING_CALLBACK);
      context.addDestructionCallback(inj2348_RepositoriesPresenter, new DestructionCallback<RepositoriesPresenter>() {
        public void destroy(final RepositoriesPresenter obj) {
          var47.remove();
          var48.remove();
        }
      });
      return inj2348_RepositoriesPresenter;
    }
  };
  private final CreationalCallback<RepositoriesPresenterActivity> inj2352_RepositoriesPresenterActivity_creational = new CreationalCallback<RepositoriesPresenterActivity>() {
    public RepositoriesPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var49 = inj2292_PlaceManagerImpl;
      final RepositoriesPresenterActivity inj2351_RepositoriesPresenterActivity = new RepositoriesPresenterActivity(var49);
      context.addBean(context.getBeanReference(RepositoriesPresenterActivity.class, arrayOf_19635043Annotation_1824450930), inj2351_RepositoriesPresenterActivity);
      _$285107124_realPresenter(inj2351_RepositoriesPresenterActivity, inj2349_RepositoriesPresenter_creational.getInstance(context));
      return inj2351_RepositoriesPresenterActivity;
    }
  };
  private InitializationCallback<MarkdownLiveView> init_inj670_MarkdownLiveView = new InitializationCallback<MarkdownLiveView>() {
    public void init(final MarkdownLiveView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MarkdownLiveView> inj2355_MarkdownLiveView_creational = new CreationalCallback<MarkdownLiveView>() {
    public MarkdownLiveView getInstance(final CreationalContext context) {
      final MarkdownLiveView inj670_MarkdownLiveView = new MarkdownLiveView();
      context.addBean(context.getBeanReference(MarkdownLiveView.class, arrayOf_19635043Annotation_1909101200), inj670_MarkdownLiveView);
      context.addInitializationCallback(inj670_MarkdownLiveView, init_inj670_MarkdownLiveView);
      return inj670_MarkdownLiveView;
    }
  };
  private final CreationalCallback<MarkdownLivePresenter> inj2354_MarkdownLivePresenter_creational = new CreationalCallback<MarkdownLivePresenter>() {
    public MarkdownLivePresenter getInstance(final CreationalContext context) {
      final MarkdownLivePresenter inj2353_MarkdownLivePresenter = new MarkdownLivePresenter();
      context.addBean(context.getBeanReference(MarkdownLivePresenter.class, arrayOf_19635043Annotation_1909101200), inj2353_MarkdownLivePresenter);
      inj2353_MarkdownLivePresenter.view = inj2355_MarkdownLiveView_creational.getInstance(context);
      final Subscription var50 = CDI.subscribeLocal("org.uberfire.client.markdown.MarkdownTextContent", new AbstractCDIEventCallback<MarkdownTextContent>() {
        public void fireEvent(final MarkdownTextContent event) {
          inj2353_MarkdownLivePresenter.loadContent(event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.markdown.MarkdownTextContent []";
        }
      });
      context.addDestructionCallback(inj2353_MarkdownLivePresenter, new DestructionCallback<MarkdownLivePresenter>() {
        public void destroy(final MarkdownLivePresenter obj) {
          var50.remove();
        }
      });
      return inj2353_MarkdownLivePresenter;
    }
  };
  private final CreationalCallback<MultiPageEditorView> inj2357_MultiPageEditorView_creational = new CreationalCallback<MultiPageEditorView>() {
    public MultiPageEditorView getInstance(final CreationalContext context) {
      final MultiPageEditorView inj2356_MultiPageEditorView = new MultiPageEditorView();
      context.addBean(context.getBeanReference(MultiPageEditorView.class, arrayOf_19635043Annotation_1909101200), inj2356_MultiPageEditorView);
      return inj2356_MultiPageEditorView;
    }
  };
  private InitializationCallback<RepositoryEditorView> init_inj693_RepositoryEditorView = new InitializationCallback<RepositoryEditorView>() {
    public void init(final RepositoryEditorView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<RepositoryEditorView> inj2360_RepositoryEditorView_creational = new CreationalCallback<RepositoryEditorView>() {
    public RepositoryEditorView getInstance(final CreationalContext context) {
      final RepositoryEditorView inj693_RepositoryEditorView = new RepositoryEditorView();
      context.addBean(context.getBeanReference(RepositoryEditorView.class, arrayOf_19635043Annotation_1909101200), inj693_RepositoryEditorView);
      context.addInitializationCallback(inj693_RepositoryEditorView, init_inj693_RepositoryEditorView);
      return inj693_RepositoryEditorView;
    }
  };
  private final CreationalCallback<RepositoryEditorPresenter> inj2359_RepositoryEditorPresenter_creational = new CreationalCallback<RepositoryEditorPresenter>() {
    public RepositoryEditorPresenter getInstance(final CreationalContext context) {
      final RepositoryEditorPresenter inj2358_RepositoryEditorPresenter = new RepositoryEditorPresenter();
      context.addBean(context.getBeanReference(RepositoryEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2358_RepositoryEditorPresenter);
      _565882618_vfsService(inj2358_RepositoryEditorPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      inj2358_RepositoryEditorPresenter.view = inj2360_RepositoryEditorView_creational.getInstance(context);
      return inj2358_RepositoryEditorPresenter;
    }
  };
  private final CreationalCallback<RepositoryEditorPresenterActivity> inj2362_RepositoryEditorPresenterActivity_creational = new CreationalCallback<RepositoryEditorPresenterActivity>() {
    public RepositoryEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var51 = inj2292_PlaceManagerImpl;
      final RepositoryEditorPresenterActivity inj2361_RepositoryEditorPresenterActivity = new RepositoryEditorPresenterActivity(var51);
      context.addBean(context.getBeanReference(RepositoryEditorPresenterActivity.class, arrayOf_19635043Annotation_1009268860), inj2361_RepositoryEditorPresenterActivity);
      _$1222153175_realPresenter(inj2361_RepositoryEditorPresenterActivity, inj2359_RepositoryEditorPresenter_creational.getInstance(context));
      return inj2361_RepositoryEditorPresenterActivity;
    }
  };
  private final CreationalCallback<PanelHelperNorth> inj2364_PanelHelperNorth_creational = new CreationalCallback<PanelHelperNorth>() {
    public PanelHelperNorth getInstance(final CreationalContext context) {
      final PanelHelperNorth inj2363_PanelHelperNorth = new PanelHelperNorth();
      context.addBean(context.getBeanReference(PanelHelperNorth.class, arrayOf_19635043Annotation_304328246), inj2363_PanelHelperNorth);
      _1798295605_factory(inj2363_PanelHelperNorth, inj2262_DefaultBeanFactory);
      return inj2363_PanelHelperNorth;
    }
  };
  private final PanelHelperNorth inj2363_PanelHelperNorth = inj2364_PanelHelperNorth_creational.getInstance(context);
  private final CreationalCallback<PanelHelperSouth> inj2366_PanelHelperSouth_creational = new CreationalCallback<PanelHelperSouth>() {
    public PanelHelperSouth getInstance(final CreationalContext context) {
      final PanelHelperSouth inj2365_PanelHelperSouth = new PanelHelperSouth();
      context.addBean(context.getBeanReference(PanelHelperSouth.class, arrayOf_19635043Annotation_798604784), inj2365_PanelHelperSouth);
      _1802916093_factory(inj2365_PanelHelperSouth, inj2262_DefaultBeanFactory);
      return inj2365_PanelHelperSouth;
    }
  };
  private final PanelHelperSouth inj2365_PanelHelperSouth = inj2366_PanelHelperSouth_creational.getInstance(context);
  private final CreationalCallback<PanelHelperEast> inj2368_PanelHelperEast_creational = new CreationalCallback<PanelHelperEast>() {
    public PanelHelperEast getInstance(final CreationalContext context) {
      final PanelHelperEast inj2367_PanelHelperEast = new PanelHelperEast();
      context.addBean(context.getBeanReference(PanelHelperEast.class, arrayOf_19635043Annotation_259448057), inj2367_PanelHelperEast);
      _$1327745331_factory(inj2367_PanelHelperEast, inj2262_DefaultBeanFactory);
      return inj2367_PanelHelperEast;
    }
  };
  private final PanelHelperEast inj2367_PanelHelperEast = inj2368_PanelHelperEast_creational.getInstance(context);
  private final CreationalCallback<PanelHelperWest> inj2370_PanelHelperWest_creational = new CreationalCallback<PanelHelperWest>() {
    public PanelHelperWest getInstance(final CreationalContext context) {
      final PanelHelperWest inj2369_PanelHelperWest = new PanelHelperWest();
      context.addBean(context.getBeanReference(PanelHelperWest.class, arrayOf_19635043Annotation_1508307357), inj2369_PanelHelperWest);
      _$1327205249_factory(inj2369_PanelHelperWest, inj2262_DefaultBeanFactory);
      return inj2369_PanelHelperWest;
    }
  };
  private final PanelHelperWest inj2369_PanelHelperWest = inj2370_PanelHelperWest_creational.getInstance(context);
  private InitializationCallback<RootWorkbenchPanelView> init_inj2371_RootWorkbenchPanelView = new InitializationCallback<RootWorkbenchPanelView>() {
    public void init(final RootWorkbenchPanelView obj) {
      _$1625293394_setupDragAndDrop(obj);
    }
  };
  private final CreationalCallback<RootWorkbenchPanelView> inj2372_RootWorkbenchPanelView_creational = new CreationalCallback<RootWorkbenchPanelView>() {
    public RootWorkbenchPanelView getInstance(final CreationalContext context) {
      final RootWorkbenchPanelView inj2371_RootWorkbenchPanelView = new RootWorkbenchPanelView();
      context.addBean(context.getBeanReference(RootWorkbenchPanelView.class, arrayOf_19635043Annotation_1626376289), inj2371_RootWorkbenchPanelView);
      _$1625293394_helperNorth(inj2371_RootWorkbenchPanelView, inj2363_PanelHelperNorth);
      _$1625293394_helperSouth(inj2371_RootWorkbenchPanelView, inj2365_PanelHelperSouth);
      _$1625293394_helperEast(inj2371_RootWorkbenchPanelView, inj2367_PanelHelperEast);
      _$1625293394_helperWest(inj2371_RootWorkbenchPanelView, inj2369_PanelHelperWest);
      _$1625293394_dndManager(inj2371_RootWorkbenchPanelView, inj2264_WorkbenchDragAndDropManager);
      _$1625293394_panelManager(inj2371_RootWorkbenchPanelView, inj2270_PanelManager);
      _$1625293394_factory(inj2371_RootWorkbenchPanelView, inj2262_DefaultBeanFactory);
      context.addInitializationCallback(inj2371_RootWorkbenchPanelView, init_inj2371_RootWorkbenchPanelView);
      return inj2371_RootWorkbenchPanelView;
    }
  };
  private InitializationCallback<RootWorkbenchPanelPresenter> init_inj2373_RootWorkbenchPanelPresenter = new InitializationCallback<RootWorkbenchPanelPresenter>() {
    public void init(final RootWorkbenchPanelPresenter obj) {
      _193002815_init(obj);
    }
  };
  private final CreationalCallback<RootWorkbenchPanelPresenter> inj2374_RootWorkbenchPanelPresenter_creational = new CreationalCallback<RootWorkbenchPanelPresenter>() {
    public RootWorkbenchPanelPresenter getInstance(final CreationalContext context) {
      final WorkbenchPanelView var52 = inj2372_RootWorkbenchPanelView_creational.getInstance(context);
      final PanelManager var53 = inj2270_PanelManager;
      final Event<MaximizePlaceEvent> var54 = inj2249_EventProvider.provide(new Class[] { MaximizePlaceEvent.class }, null);
      final Event<MinimizePlaceEvent> var55 = inj2249_EventProvider.provide(new Class[] { MinimizePlaceEvent.class }, null);
      final RootWorkbenchPanelPresenter inj2373_RootWorkbenchPanelPresenter = new RootWorkbenchPanelPresenter(var52, var53, var54, var55);
      context.addBean(context.getBeanReference(RootWorkbenchPanelPresenter.class, arrayOf_19635043Annotation_1626376289), inj2373_RootWorkbenchPanelPresenter);
      context.addInitializationCallback(inj2373_RootWorkbenchPanelPresenter, init_inj2373_RootWorkbenchPanelPresenter);
      return inj2373_RootWorkbenchPanelPresenter;
    }
  };
  private final CreationalCallback<PopupView> inj2376_PopupView_creational = new CreationalCallback<PopupView>() {
    public PopupView getInstance(final CreationalContext context) {
      final PopupView inj2375_PopupView = new PopupView();
      context.addBean(context.getBeanReference(PopupView.class, arrayOf_19635043Annotation_1909101200), inj2375_PopupView);
      return inj2375_PopupView;
    }
  };
  private InitializationCallback<MultipleActivitiesFoundPresenterActivity> init_inj2377_MultipleActivitiesFoundPresenterActivity = new InitializationCallback<MultipleActivitiesFoundPresenterActivity>() {
    public void init(final MultipleActivitiesFoundPresenterActivity obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MultipleActivitiesFoundPresenterActivity> inj2378_MultipleActivitiesFoundPresenterActivity_creational = new CreationalCallback<MultipleActivitiesFoundPresenterActivity>() {
    public MultipleActivitiesFoundPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var56 = inj2292_PlaceManagerImpl;
      final MultipleActivitiesFoundPresenterActivity inj2377_MultipleActivitiesFoundPresenterActivity = new MultipleActivitiesFoundPresenterActivity(var56);
      context.addBean(context.getBeanReference(MultipleActivitiesFoundPresenterActivity.class, arrayOf_19635043Annotation_1374778235), inj2377_MultipleActivitiesFoundPresenterActivity);
      _138245081_realPresenter(inj2377_MultipleActivitiesFoundPresenterActivity, inj2298_MultipleActivitiesFoundPresenter);
      _$1708929533_iocManager(inj2377_MultipleActivitiesFoundPresenterActivity, inj2241_IOCBeanManagerProvider.get());
      _$1708929533_closePlaceEvent(inj2377_MultipleActivitiesFoundPresenterActivity, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$1708929533_popup(inj2377_MultipleActivitiesFoundPresenterActivity, inj2376_PopupView_creational.getInstance(context));
      final Subscription var57 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$1708929533_onClose(inj2377_MultipleActivitiesFoundPresenterActivity, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2377_MultipleActivitiesFoundPresenterActivity, new DestructionCallback<AbstractPopupActivity>() {
        public void destroy(final AbstractPopupActivity obj) {
          var57.remove();
        }
      });
      context.addInitializationCallback(inj2377_MultipleActivitiesFoundPresenterActivity, init_inj2377_MultipleActivitiesFoundPresenterActivity);
      return inj2377_MultipleActivitiesFoundPresenterActivity;
    }
  };
  private final CreationalCallback<MultiPageEditor> inj2380_MultiPageEditor_creational = new CreationalCallback<MultiPageEditor>() {
    public MultiPageEditor getInstance(final CreationalContext context) {
      final MultiPageEditor inj2379_MultiPageEditor = new MultiPageEditor();
      context.addBean(context.getBeanReference(MultiPageEditor.class, arrayOf_19635043Annotation_1909101200), inj2379_MultiPageEditor);
      _$76115871_view(inj2379_MultiPageEditor, inj2357_MultiPageEditorView_creational.getInstance(context));
      return inj2379_MultiPageEditor;
    }
  };
  private final CreationalCallback<RootPanelProvider> inj2381_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj2239_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_1909101200), inj2239_RootPanelProvider);
      return inj2239_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj2239_RootPanelProvider = inj2381_RootPanelProvider_creational.getInstance(context);
  private InitializationCallback<CreateRepositoryForm> init_inj2382_CreateRepositoryForm = new InitializationCallback<CreateRepositoryForm>() {
    public void init(final CreateRepositoryForm obj) {
      obj.init();
    }
  };
  private final CreationalCallback<CreateRepositoryForm> inj2383_CreateRepositoryForm_creational = new CreationalCallback<CreateRepositoryForm>() {
    public CreateRepositoryForm getInstance(final CreationalContext context) {
      final CreateRepositoryForm inj2382_CreateRepositoryForm = new CreateRepositoryForm();
      context.addBean(context.getBeanReference(CreateRepositoryForm.class, arrayOf_19635043Annotation_1909101200), inj2382_CreateRepositoryForm);
      _$1321361073_vfsService(inj2382_CreateRepositoryForm, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      _$1321361073_rootService(inj2382_CreateRepositoryForm, inj2251_CallerProvider.provide(new Class[] { FileExplorerRootService.class }, null));
      _$1321361073_event(inj2382_CreateRepositoryForm, inj2249_EventProvider.provide(new Class[] { Root.class }, null));
      context.addInitializationCallback(inj2382_CreateRepositoryForm, init_inj2382_CreateRepositoryForm);
      return inj2382_CreateRepositoryForm;
    }
  };
  private final CreationalCallback<InitBallotProvider> inj2384_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj2247_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_1909101200), inj2247_InitBallotProvider);
      return inj2247_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj2247_InitBallotProvider = inj2384_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<TextEditorPresenter> inj2386_TextEditorPresenter_creational = new CreationalCallback<TextEditorPresenter>() {
    public TextEditorPresenter getInstance(final CreationalContext context) {
      final TextEditorPresenter inj2385_TextEditorPresenter = new TextEditorPresenter();
      context.addBean(context.getBeanReference(TextEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2385_TextEditorPresenter);
      inj2385_TextEditorPresenter.view = inj2277_TextEditorView_creational.getInstance(context);
      _149710705_vfsServices(inj2385_TextEditorPresenter, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      return inj2385_TextEditorPresenter;
    }
  };
  private final CreationalCallback<DataBinderProvider> inj2387_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj2243_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_1909101200), inj2243_DataBinderProvider);
      return inj2243_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj2243_DataBinderProvider = inj2387_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<TextEditorPresenterActivity> inj2389_TextEditorPresenterActivity_creational = new CreationalCallback<TextEditorPresenterActivity>() {
    public TextEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var58 = inj2292_PlaceManagerImpl;
      final TextEditorPresenterActivity inj2388_TextEditorPresenterActivity = new TextEditorPresenterActivity(var58);
      context.addBean(context.getBeanReference(TextEditorPresenterActivity.class, arrayOf_19635043Annotation_1544573185), inj2388_TextEditorPresenterActivity);
      _$118440544_realPresenter(inj2388_TextEditorPresenterActivity, inj2386_TextEditorPresenter_creational.getInstance(context));
      return inj2388_TextEditorPresenterActivity;
    }
  };
  private final CreationalCallback<RequestDispatcherProvider> inj2390_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj2237_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_1909101200), inj2237_RequestDispatcherProvider);
      return inj2237_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj2237_RequestDispatcherProvider = inj2390_RequestDispatcherProvider_creational.getInstance(context);
  private InitializationCallback<MarkdownLiveEditorView> init_inj669_MarkdownLiveEditorView = new InitializationCallback<MarkdownLiveEditorView>() {
    public void init(final MarkdownLiveEditorView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<MarkdownLiveEditorView> inj2393_MarkdownLiveEditorView_creational = new CreationalCallback<MarkdownLiveEditorView>() {
    public MarkdownLiveEditorView getInstance(final CreationalContext context) {
      final MarkdownLiveEditorView inj669_MarkdownLiveEditorView = new MarkdownLiveEditorView();
      context.addBean(context.getBeanReference(MarkdownLiveEditorView.class, arrayOf_19635043Annotation_1909101200), inj669_MarkdownLiveEditorView);
      _363979058_event(inj669_MarkdownLiveEditorView, inj2249_EventProvider.provide(new Class[] { MarkdownTextContent.class }, null));
      context.addInitializationCallback(inj669_MarkdownLiveEditorView, init_inj669_MarkdownLiveEditorView);
      return inj669_MarkdownLiveEditorView;
    }
  };
  private final CreationalCallback<MarkdownLiveEditorPresenter> inj2392_MarkdownLiveEditorPresenter_creational = new CreationalCallback<MarkdownLiveEditorPresenter>() {
    public MarkdownLiveEditorPresenter getInstance(final CreationalContext context) {
      final MarkdownLiveEditorPresenter inj2391_MarkdownLiveEditorPresenter = new MarkdownLiveEditorPresenter();
      context.addBean(context.getBeanReference(MarkdownLiveEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2391_MarkdownLiveEditorPresenter);
      inj2391_MarkdownLiveEditorPresenter.view = inj2393_MarkdownLiveEditorView_creational.getInstance(context);
      return inj2391_MarkdownLiveEditorPresenter;
    }
  };
  private final CreationalCallback<MarkdownLiveEditorPresenterActivity> inj2395_MarkdownLiveEditorPresenterActivity_creational = new CreationalCallback<MarkdownLiveEditorPresenterActivity>() {
    public MarkdownLiveEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var59 = inj2292_PlaceManagerImpl;
      final MarkdownLiveEditorPresenterActivity inj2394_MarkdownLiveEditorPresenterActivity = new MarkdownLiveEditorPresenterActivity(var59);
      context.addBean(context.getBeanReference(MarkdownLiveEditorPresenterActivity.class, arrayOf_19635043Annotation_1967159266), inj2394_MarkdownLiveEditorPresenterActivity);
      _$396060566_realPresenter(inj2394_MarkdownLiveEditorPresenterActivity, inj2392_MarkdownLiveEditorPresenter_creational.getInstance(context));
      return inj2394_MarkdownLiveEditorPresenterActivity;
    }
  };
  private final CreationalCallback<VerticalSplitterPanel> inj2397_VerticalSplitterPanel_creational = new CreationalCallback<VerticalSplitterPanel>() {
    public VerticalSplitterPanel getInstance(final CreationalContext context) {
      final VerticalSplitterPanel inj2396_VerticalSplitterPanel = new VerticalSplitterPanel();
      context.addBean(context.getBeanReference(VerticalSplitterPanel.class, arrayOf_19635043Annotation_1909101200), inj2396_VerticalSplitterPanel);
      return inj2396_VerticalSplitterPanel;
    }
  };
  private InitializationCallback<CloneRepositoryForm> init_inj2398_CloneRepositoryForm = new InitializationCallback<CloneRepositoryForm>() {
    public void init(final CloneRepositoryForm obj) {
      obj.init();
    }
  };
  private final CreationalCallback<CloneRepositoryForm> inj2399_CloneRepositoryForm_creational = new CreationalCallback<CloneRepositoryForm>() {
    public CloneRepositoryForm getInstance(final CreationalContext context) {
      final CloneRepositoryForm inj2398_CloneRepositoryForm = new CloneRepositoryForm();
      context.addBean(context.getBeanReference(CloneRepositoryForm.class, arrayOf_19635043Annotation_1909101200), inj2398_CloneRepositoryForm);
      _$1112537939_vfsService(inj2398_CloneRepositoryForm, inj2251_CallerProvider.provide(new Class[] { VFSService.class }, null));
      _$1112537939_rootService(inj2398_CloneRepositoryForm, inj2251_CallerProvider.provide(new Class[] { FileExplorerRootService.class }, null));
      _$1112537939_event(inj2398_CloneRepositoryForm, inj2249_EventProvider.provide(new Class[] { Root.class }, null));
      context.addInitializationCallback(inj2398_CloneRepositoryForm, init_inj2398_CloneRepositoryForm);
      return inj2398_CloneRepositoryForm;
    }
  };
  private final CreationalCallback<MarkdownType> inj2401_MarkdownType_creational = new CreationalCallback<MarkdownType>() {
    public MarkdownType getInstance(final CreationalContext context) {
      final MarkdownType inj2400_MarkdownType = new MarkdownType();
      context.addBean(context.getBeanReference(MarkdownType.class, arrayOf_19635043Annotation_1909101200), inj2400_MarkdownType);
      return inj2400_MarkdownType;
    }
  };
  private final MarkdownType inj2400_MarkdownType = inj2401_MarkdownType_creational.getInstance(context);
  private InitializationCallback<NotificationPopupView> init_inj2402_NotificationPopupView = new InitializationCallback<NotificationPopupView>() {
    public void init(final NotificationPopupView obj) {
      obj.init();
    }
  };
  private final CreationalCallback<NotificationPopupView> inj2403_NotificationPopupView_creational = new CreationalCallback<NotificationPopupView>() {
    public NotificationPopupView getInstance(final CreationalContext context) {
      final NotificationPopupView inj2402_NotificationPopupView = new NotificationPopupView();
      context.addBean(context.getBeanReference(NotificationPopupView.class, arrayOf_19635043Annotation_1909101200), inj2402_NotificationPopupView);
      context.addInitializationCallback(inj2402_NotificationPopupView, init_inj2402_NotificationPopupView);
      return inj2402_NotificationPopupView;
    }
  };
  private final CreationalCallback<HomePerspectiveActivity> inj2405_HomePerspectiveActivity_creational = new CreationalCallback<HomePerspectiveActivity>() {
    public HomePerspectiveActivity getInstance(final CreationalContext context) {
      final PlaceManager var60 = inj2292_PlaceManagerImpl;
      final HomePerspectiveActivity inj2404_HomePerspectiveActivity = new HomePerspectiveActivity(var60);
      context.addBean(context.getBeanReference(HomePerspectiveActivity.class, arrayOf_19635043Annotation_1623288266), inj2404_HomePerspectiveActivity);
      _$1207394361_realPresenter(inj2404_HomePerspectiveActivity, inj2327_HomePerspective);
      _239180292_panelManager(inj2404_HomePerspectiveActivity, inj2270_PanelManager);
      _239180292_placeManager(inj2404_HomePerspectiveActivity, inj2292_PlaceManagerImpl);
      _239180292_menuBar(inj2404_HomePerspectiveActivity, inj2308_WorkbenchMenuBarPresenter);
      _239180292_toolBarPresenter(inj2404_HomePerspectiveActivity, inj2303_WorkbenchToolBarPresenter);
      _239180292_wbServices(inj2404_HomePerspectiveActivity, inj2251_CallerProvider.provide(new Class[] { WorkbenchServices.class }, null));
      return inj2404_HomePerspectiveActivity;
    }
  };
  private final CreationalCallback<TextBox> inj2408_TextBox_creational = new CreationalCallback<TextBox>() {
    public TextBox getInstance(final CreationalContext context) {
      final TextBox inj1884_TextBox = new TextBox();
      context.addBean(context.getBeanReference(TextBox.class, arrayOf_19635043Annotation_1909101200), inj1884_TextBox);
      return inj1884_TextBox;
    }
  };
  private final CreationalCallback<PropertyEditor> inj2407_PropertyEditor_creational = new CreationalCallback<PropertyEditor>() {
    public PropertyEditor getInstance(final CreationalContext context) {
      final PropertyEditor inj2406_PropertyEditor = new PropertyEditor();
      context.addBean(context.getBeanReference(PropertyEditor.class, arrayOf_19635043Annotation_1909101200), inj2406_PropertyEditor);
      _$1067079459_name(inj2406_PropertyEditor, inj2408_TextBox_creational.getInstance(context));
      _$1067079459_documentation(inj2406_PropertyEditor, inj2408_TextBox_creational.getInstance(context));
      context.addInitializationCallback(inj2406_PropertyEditor, new InitializationCallback<PropertyEditor>() {
        public void init(PropertyEditor obj) {
          org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource var61 = GWT.create(org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource.class);
          Element var62 = TemplateUtil.getRootTemplateElement(var61.getContents().getText(), "");
          Map<String, Element> var63 = TemplateUtil.getDataFieldElements(var62);
          Map<String, Widget> var64 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.jbpm.datamodeler.editor.client.editors.PropertyEditor", "org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html", _$1067079459_dataObjectPropertiesLabel(inj2406_PropertyEditor), var63, "dataObjectPropertiesLabel");
          TemplateUtil.compositeComponentReplace("org.jbpm.datamodeler.editor.client.editors.PropertyEditor", "org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html", new ElementWrapperWidget(_$1067079459_button(inj2406_PropertyEditor)), var63, "button");
          TemplateUtil.compositeComponentReplace("org.jbpm.datamodeler.editor.client.editors.PropertyEditor", "org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html", _$1067079459_name(inj2406_PropertyEditor), var63, "name");
          TemplateUtil.compositeComponentReplace("org.jbpm.datamodeler.editor.client.editors.PropertyEditor", "org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html", _$1067079459_documentation(inj2406_PropertyEditor), var63, "documentation");
          var64.put("dataObjectPropertiesLabel", _$1067079459_dataObjectPropertiesLabel(inj2406_PropertyEditor));
          var64.put("button", new ElementWrapperWidget(_$1067079459_button(inj2406_PropertyEditor)));
          var64.put("name", _$1067079459_name(inj2406_PropertyEditor));
          var64.put("documentation", _$1067079459_documentation(inj2406_PropertyEditor));
          TemplateUtil.initWidget(inj2406_PropertyEditor, var62, var64.values());
          TemplateUtil.setupWrappedElementEventHandler(inj2406_PropertyEditor, var64.get("button"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj2406_PropertyEditor.clickButton(event);
            }
          }, ClickEvent.getType());
        }
      });
      return inj2406_PropertyEditor;
    }
  };
  private final CreationalCallback<DataModelBrowser> inj2411_DataModelBrowser_creational = new CreationalCallback<DataModelBrowser>() {
    public DataModelBrowser getInstance(final CreationalContext context) {
      final DataModelBrowser inj641_DataModelBrowser = new DataModelBrowser();
      context.addBean(context.getBeanReference(DataModelBrowser.class, arrayOf_19635043Annotation_1909101200), inj641_DataModelBrowser);
      return inj641_DataModelBrowser;
    }
  };
  private final CreationalCallback<DataObjectEditor> inj2412_DataObjectEditor_creational = new CreationalCallback<DataObjectEditor>() {
    public DataObjectEditor getInstance(final CreationalContext context) {
      final DataObjectEditor inj642_DataObjectEditor = new DataObjectEditor();
      context.addBean(context.getBeanReference(DataObjectEditor.class, arrayOf_19635043Annotation_1909101200), inj642_DataObjectEditor);
      return inj642_DataObjectEditor;
    }
  };
  private final CreationalCallback<DataModelEditorViewImpl> inj2410_DataModelEditorViewImpl_creational = new CreationalCallback<DataModelEditorViewImpl>() {
    public DataModelEditorViewImpl getInstance(final CreationalContext context) {
      final DataModelEditorViewImpl inj2409_DataModelEditorViewImpl = new DataModelEditorViewImpl();
      context.addBean(context.getBeanReference(DataModelEditorViewImpl.class, arrayOf_19635043Annotation_1909101200), inj2409_DataModelEditorViewImpl);
      _$1324720234_propertyEditor(inj2409_DataModelEditorViewImpl, inj2407_PropertyEditor_creational.getInstance(context));
      _$1324720234_dataModelBrowser(inj2409_DataModelEditorViewImpl, inj2411_DataModelBrowser_creational.getInstance(context));
      _$1324720234_dataObjectEditor(inj2409_DataModelEditorViewImpl, inj2412_DataObjectEditor_creational.getInstance(context));
      context.addInitializationCallback(inj2409_DataModelEditorViewImpl, new InitializationCallback<DataModelEditorViewImpl>() {
        public void init(DataModelEditorViewImpl obj) {
          org_jbpm_datamodeler_editor_client_editors_DataModelEditorViewImplTemplateResource var65 = GWT.create(org_jbpm_datamodeler_editor_client_editors_DataModelEditorViewImplTemplateResource.class);
          Element var66 = TemplateUtil.getRootTemplateElement(var65.getContents().getText(), "");
          Map<String, Element> var67 = TemplateUtil.getDataFieldElements(var66);
          Map<String, Widget> var68 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl", "org/jbpm/datamodeler/editor/client/editors/DataModelEditorViewImpl.html", _$1324720234_contentsPanel(inj2409_DataModelEditorViewImpl), var67, "contentsPanel");
          var68.put("contentsPanel", _$1324720234_contentsPanel(inj2409_DataModelEditorViewImpl));
          TemplateUtil.initWidget(inj2409_DataModelEditorViewImpl, var66, var68.values());
        }
      });
      return inj2409_DataModelEditorViewImpl;
    }
  };
  private InitializationCallback<DataModelEditorPresenter> init_inj2413_DataModelEditorPresenter = new InitializationCallback<DataModelEditorPresenter>() {
    public void init(final DataModelEditorPresenter obj) {
      obj.init();
    }
  };
  private final CreationalCallback<DataModelEditorPresenter> inj2414_DataModelEditorPresenter_creational = new CreationalCallback<DataModelEditorPresenter>() {
    public DataModelEditorPresenter getInstance(final CreationalContext context) {
      final DataModelEditorPresenter inj2413_DataModelEditorPresenter = new DataModelEditorPresenter();
      context.addBean(context.getBeanReference(DataModelEditorPresenter.class, arrayOf_19635043Annotation_1909101200), inj2413_DataModelEditorPresenter);
      _$1740030057_view(inj2413_DataModelEditorPresenter, inj2410_DataModelEditorViewImpl_creational.getInstance(context));
      _$1740030057_notification(inj2413_DataModelEditorPresenter, inj2249_EventProvider.provide(new Class[] { NotificationEvent.class }, null));
      context.addInitializationCallback(inj2413_DataModelEditorPresenter, init_inj2413_DataModelEditorPresenter);
      return inj2413_DataModelEditorPresenter;
    }
  };
  private InitializationCallback<DataModelEditorPresenterActivity> init_inj2415_DataModelEditorPresenterActivity = new InitializationCallback<DataModelEditorPresenterActivity>() {
    public void init(final DataModelEditorPresenterActivity obj) {
      obj.init();
    }
  };
  private final CreationalCallback<DataModelEditorPresenterActivity> inj2416_DataModelEditorPresenterActivity_creational = new CreationalCallback<DataModelEditorPresenterActivity>() {
    public DataModelEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var69 = inj2292_PlaceManagerImpl;
      final DataModelEditorPresenterActivity inj2415_DataModelEditorPresenterActivity = new DataModelEditorPresenterActivity(var69);
      context.addBean(context.getBeanReference(DataModelEditorPresenterActivity.class, arrayOf_19635043Annotation_224919741), inj2415_DataModelEditorPresenterActivity);
      _740167622_realPresenter(inj2415_DataModelEditorPresenterActivity, inj2414_DataModelEditorPresenter_creational.getInstance(context));
      context.addInitializationCallback(inj2415_DataModelEditorPresenterActivity, init_inj2415_DataModelEditorPresenterActivity);
      return inj2415_DataModelEditorPresenterActivity;
    }
  };
  private final CreationalCallback<WorkbenchPartView> inj2419_WorkbenchPartView_creational = new CreationalCallback<WorkbenchPartView>() {
    public WorkbenchPartView getInstance(final CreationalContext context) {
      final WorkbenchPartView inj640_WorkbenchPartView = new WorkbenchPartView();
      context.addBean(context.getBeanReference(WorkbenchPartView.class, arrayOf_19635043Annotation_1909101200), inj640_WorkbenchPartView);
      return inj640_WorkbenchPartView;
    }
  };
  private InitializationCallback<WorkbenchPartPresenter> init_inj2417_WorkbenchPartPresenter = new InitializationCallback<WorkbenchPartPresenter>() {
    public void init(final WorkbenchPartPresenter obj) {
      _1456584152_init(obj);
    }
  };
  private final CreationalCallback<WorkbenchPartPresenter> inj2418_WorkbenchPartPresenter_creational = new CreationalCallback<WorkbenchPartPresenter>() {
    public WorkbenchPartPresenter getInstance(final CreationalContext context) {
      final View var70 = inj2419_WorkbenchPartView_creational.getInstance(context);
      final WorkbenchPartPresenter inj2417_WorkbenchPartPresenter = new WorkbenchPartPresenter(var70);
      context.addBean(context.getBeanReference(WorkbenchPartPresenter.class, arrayOf_19635043Annotation_1909101200), inj2417_WorkbenchPartPresenter);
      context.addInitializationCallback(inj2417_WorkbenchPartPresenter, init_inj2417_WorkbenchPartPresenter);
      return inj2417_WorkbenchPartPresenter;
    }
  };
  private InitializationCallback<ActivityNotFoundPresenterActivity> init_inj2420_ActivityNotFoundPresenterActivity = new InitializationCallback<ActivityNotFoundPresenterActivity>() {
    public void init(final ActivityNotFoundPresenterActivity obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ActivityNotFoundPresenterActivity> inj2421_ActivityNotFoundPresenterActivity_creational = new CreationalCallback<ActivityNotFoundPresenterActivity>() {
    public ActivityNotFoundPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var71 = inj2292_PlaceManagerImpl;
      final ActivityNotFoundPresenterActivity inj2420_ActivityNotFoundPresenterActivity = new ActivityNotFoundPresenterActivity(var71);
      context.addBean(context.getBeanReference(ActivityNotFoundPresenterActivity.class, arrayOf_19635043Annotation_918196602), inj2420_ActivityNotFoundPresenterActivity);
      _$2041313647_realPresenter(inj2420_ActivityNotFoundPresenterActivity, inj2294_ActivityNotFoundPresenter);
      _$1708929533_iocManager(inj2420_ActivityNotFoundPresenterActivity, inj2241_IOCBeanManagerProvider.get());
      _$1708929533_closePlaceEvent(inj2420_ActivityNotFoundPresenterActivity, inj2249_EventProvider.provide(new Class[] { BeforeClosePlaceEvent.class }, null));
      _$1708929533_popup(inj2420_ActivityNotFoundPresenterActivity, inj2376_PopupView_creational.getInstance(context));
      final Subscription var72 = CDI.subscribeLocal("org.uberfire.client.workbench.widgets.events.ClosePlaceEvent", new AbstractCDIEventCallback<ClosePlaceEvent>() {
        public void fireEvent(final ClosePlaceEvent event) {
          _$1708929533_onClose(inj2420_ActivityNotFoundPresenterActivity, event);
        }
        public String toString() {
          return "Observer: org.uberfire.client.workbench.widgets.events.ClosePlaceEvent []";
        }
      });
      context.addDestructionCallback(inj2420_ActivityNotFoundPresenterActivity, new DestructionCallback<AbstractPopupActivity>() {
        public void destroy(final AbstractPopupActivity obj) {
          var72.remove();
        }
      });
      context.addInitializationCallback(inj2420_ActivityNotFoundPresenterActivity, init_inj2420_ActivityNotFoundPresenterActivity);
      return inj2420_ActivityNotFoundPresenterActivity;
    }
  };
  private final CreationalCallback<MarkdownUtil> inj2423_MarkdownUtil_creational = new CreationalCallback<MarkdownUtil>() {
    public MarkdownUtil getInstance(final CreationalContext context) {
      final MarkdownUtil inj2422_MarkdownUtil = new MarkdownUtil();
      context.addBean(context.getBeanReference(MarkdownUtil.class, arrayOf_19635043Annotation_1909101200), inj2422_MarkdownUtil);
      return inj2422_MarkdownUtil;
    }
  };
  private final MarkdownUtil inj2422_MarkdownUtil = inj2423_MarkdownUtil_creational.getInstance(context);
  private final CreationalCallback<MetaFileEditorPresenterActivity> inj2425_MetaFileEditorPresenterActivity_creational = new CreationalCallback<MetaFileEditorPresenterActivity>() {
    public MetaFileEditorPresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var73 = inj2292_PlaceManagerImpl;
      final MetaFileEditorPresenterActivity inj2424_MetaFileEditorPresenterActivity = new MetaFileEditorPresenterActivity(var73);
      context.addBean(context.getBeanReference(MetaFileEditorPresenterActivity.class, arrayOf_19635043Annotation_882894192), inj2424_MetaFileEditorPresenterActivity);
      _$951038061_realPresenter(inj2424_MetaFileEditorPresenterActivity, inj2333_MetaFileEditorPresenter_creational.getInstance(context));
      return inj2424_MetaFileEditorPresenterActivity;
    }
  };
  private final CreationalCallback<HorizontalSplitterPanel> inj2427_HorizontalSplitterPanel_creational = new CreationalCallback<HorizontalSplitterPanel>() {
    public HorizontalSplitterPanel getInstance(final CreationalContext context) {
      final HorizontalSplitterPanel inj2426_HorizontalSplitterPanel = new HorizontalSplitterPanel();
      context.addBean(context.getBeanReference(HorizontalSplitterPanel.class, arrayOf_19635043Annotation_1909101200), inj2426_HorizontalSplitterPanel);
      return inj2426_HorizontalSplitterPanel;
    }
  };
  private final CreationalCallback<MarkdownLivePresenterActivity> inj2429_MarkdownLivePresenterActivity_creational = new CreationalCallback<MarkdownLivePresenterActivity>() {
    public MarkdownLivePresenterActivity getInstance(final CreationalContext context) {
      final PlaceManager var74 = inj2292_PlaceManagerImpl;
      final MarkdownLivePresenterActivity inj2428_MarkdownLivePresenterActivity = new MarkdownLivePresenterActivity(var74);
      context.addBean(context.getBeanReference(MarkdownLivePresenterActivity.class, arrayOf_19635043Annotation_1920101153), inj2428_MarkdownLivePresenterActivity);
      _407597655_realPresenter(inj2428_MarkdownLivePresenterActivity, inj2354_MarkdownLivePresenter_creational.getInstance(context));
      return inj2428_MarkdownLivePresenterActivity;
    }
  };
  private final CreationalCallback<TextResourceType> inj2431_TextResourceType_creational = new CreationalCallback<TextResourceType>() {
    public TextResourceType getInstance(final CreationalContext context) {
      final TextResourceType inj2430_TextResourceType = new TextResourceType();
      context.addBean(context.getBeanReference(TextResourceType.class, arrayOf_19635043Annotation_1909101200), inj2430_TextResourceType);
      return inj2430_TextResourceType;
    }
  };
  private final TextResourceType inj2430_TextResourceType = inj2431_TextResourceType_creational.getInstance(context);
  static class WorkbenchDragAndDropManager_inj2261_proxy extends WorkbenchDragAndDropManager {
    private WorkbenchDragAndDropManager $$_proxy_$$;
    public void makeDraggable(IsWidget a0, IsWidget a1) {
      $$_proxy_$$.makeDraggable(a0, a1);
    }

    public void registerDropController(WorkbenchPanelView a0, DropController a1) {
      $$_proxy_$$.registerDropController(a0, a1);
    }

    public void unregisterDropController(WorkbenchPanelView a0) {
      $$_proxy_$$.unregisterDropController(a0);
    }

    public void unregisterDropControllers() {
      $$_proxy_$$.unregisterDropControllers();
    }

    public void setWorkbenchContext(WorkbenchDragContext a0) {
      $$_proxy_$$.setWorkbenchContext(a0);
    }

    public WorkbenchDragContext getWorkbenchContext() {
      return $$_proxy_$$.getWorkbenchContext();
    }

    public int hashCode() {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to hashCode() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.hashCode();
      }
    }

    public boolean equals(Object o) {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to equals() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.equals(o);
      }
    }

    public void __$setProxiedInstance$(WorkbenchDragAndDropManager proxy) {
      $$_proxy_$$ = proxy;
    }
  }
  public interface org_jbpm_datamodeler_editor_client_editors_PropertyEditorTemplateResource extends Template, ClientBundle {
  @Source("org/jbpm/datamodeler/editor/client/editors/PropertyEditor.html") public TextResource getContents(); }
  public interface org_jbpm_datamodeler_editor_client_editors_DataModelEditorViewImplTemplateResource extends Template, ClientBundle {
  @Source("org/jbpm/datamodeler/editor/client/editors/DataModelEditorViewImpl.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DefaultWorkbenchContext.class, DefaultWorkbenchContext.class, inj2257_DefaultWorkbenchContext_creational, inj2256_DefaultWorkbenchContext, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchContext.class, DefaultWorkbenchContext.class, inj2257_DefaultWorkbenchContext_creational, inj2256_DefaultWorkbenchContext, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj2258_IOCBeanManagerProvider_creational, inj2241_IOCBeanManagerProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj2258_IOCBeanManagerProvider_creational, inj2241_IOCBeanManagerProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchPickupDragController.class, WorkbenchPickupDragController.class, inj2260_WorkbenchPickupDragController_creational, inj2259_WorkbenchPickupDragController, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PickupDragController.class, WorkbenchPickupDragController.class, inj2260_WorkbenchPickupDragController_creational, inj2259_WorkbenchPickupDragController, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AbstractDragController.class, WorkbenchPickupDragController.class, inj2260_WorkbenchPickupDragController_creational, inj2259_WorkbenchPickupDragController, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DragController.class, WorkbenchPickupDragController.class, inj2260_WorkbenchPickupDragController_creational, inj2259_WorkbenchPickupDragController, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(FiresDragEvents.class, WorkbenchPickupDragController.class, inj2260_WorkbenchPickupDragController_creational, inj2259_WorkbenchPickupDragController, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DefaultBeanFactory.class, DefaultBeanFactory.class, inj2263_DefaultBeanFactory_creational, inj2262_DefaultBeanFactory, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(BeanFactory.class, DefaultBeanFactory.class, inj2263_DefaultBeanFactory_creational, inj2262_DefaultBeanFactory, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchDragAndDropManager.class, WorkbenchDragAndDropManager.class, inj2265_WorkbenchDragAndDropManager_creational, inj2264_WorkbenchDragAndDropManager, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj2266_EventProvider_creational, inj2249_EventProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj2266_EventProvider_creational, inj2249_EventProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchStatusBarView.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter.View.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchStatusBarView.class, inj2269_WorkbenchStatusBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchStatusBarPresenter.class, WorkbenchStatusBarPresenter.class, inj2268_WorkbenchStatusBarPresenter_creational, inj2267_WorkbenchStatusBarPresenter, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PanelManager.class, PanelManager.class, inj2271_PanelManager_creational, inj2270_PanelManager, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(CompassDropController.class, CompassDropController.class, inj2273_CompassDropController_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DropController.class, CompassDropController.class, inj2273_CompassDropController_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj2274_CallerProvider_creational, inj2251_CallerProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj2274_CallerProvider_creational, inj2251_CallerProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(TextEditorView.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.editors.texteditor.TextEditorPresenter.View.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, TextEditorView.class, inj2277_TextEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DefaultFileEditorPresenter.class, DefaultFileEditorPresenter.class, inj2276_DefaultFileEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj2278_MessageBusProvider_creational, inj2235_MessageBusProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj2278_MessageBusProvider_creational, inj2235_MessageBusProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SecurityEntryPoint.class, SecurityEntryPoint.class, inj2280_SecurityEntryPoint_creational, inj2279_SecurityEntryPoint, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ActivityBeansCache.class, ActivityBeansCache.class, inj2282_ActivityBeansCache_creational, inj2281_ActivityBeansCache, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RuntimeAuthorizationManager.class, RuntimeAuthorizationManager.class, inj2284_RuntimeAuthorizationManager_creational, inj2283_RuntimeAuthorizationManager, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(AuthorizationManager.class, RuntimeAuthorizationManager.class, inj2284_RuntimeAuthorizationManager_creational, inj2283_RuntimeAuthorizationManager, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ActivityManagerImpl.class, ActivityManagerImpl.class, inj2286_ActivityManagerImpl_creational, inj2285_ActivityManagerImpl, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ActivityManager.class, ActivityManagerImpl.class, inj2286_ActivityManagerImpl_creational, inj2285_ActivityManagerImpl, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(PlaceRequestHistoryMapperImpl.class, PlaceRequestHistoryMapperImpl.class, inj2289_PlaceRequestHistoryMapperImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PlaceRequestHistoryMapper.class, PlaceRequestHistoryMapperImpl.class, inj2289_PlaceRequestHistoryMapperImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(PlaceHistoryHandler.class, PlaceHistoryHandler.class, inj2288_PlaceHistoryHandler_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DefaultPlaceResolver.class, DefaultPlaceResolver.class, inj2291_DefaultPlaceResolver_creational, inj2290_DefaultPlaceResolver, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PlaceManagerImpl.class, PlaceManagerImpl.class, inj2293_PlaceManagerImpl_creational, inj2292_PlaceManagerImpl, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PlaceManager.class, PlaceManagerImpl.class, inj2293_PlaceManagerImpl_creational, inj2292_PlaceManagerImpl, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ActivityNotFoundView.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter.View.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimplePanel.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasOneWidget.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AcceptsOneWidget.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Panel.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ForIsWidget.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasWidgets.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Iterable.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, ActivityNotFoundView.class, inj2296_ActivityNotFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ActivityNotFoundPresenter.class, ActivityNotFoundPresenter.class, inj2295_ActivityNotFoundPresenter_creational, inj2294_ActivityNotFoundPresenter, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj2297_SenderProvider_creational, inj2255_SenderProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj2297_SenderProvider_creational, inj2255_SenderProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MultipleActivitiesFoundView.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter.View.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimplePanel.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasOneWidget.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AcceptsOneWidget.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Panel.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ForIsWidget.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasWidgets.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Iterable.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, MultipleActivitiesFoundView.class, inj2300_MultipleActivitiesFoundView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MultipleActivitiesFoundPresenter.class, MultipleActivitiesFoundPresenter.class, inj2299_MultipleActivitiesFoundPresenter_creational, inj2298_MultipleActivitiesFoundPresenter, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchToolBarPresenterUtils.class, WorkbenchToolBarPresenterUtils.class, inj2302_WorkbenchToolBarPresenterUtils_creational, inj2301_WorkbenchToolBarPresenterUtils, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchToolBarView.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchToolBarView.class, inj2305_WorkbenchToolBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchToolBarPresenter.class, WorkbenchToolBarPresenter.class, inj2304_WorkbenchToolBarPresenter_creational, inj2303_WorkbenchToolBarPresenter, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchMenuBarPresenterUtils.class, WorkbenchMenuBarPresenterUtils.class, inj2307_WorkbenchMenuBarPresenterUtils_creational, inj2306_WorkbenchMenuBarPresenterUtils, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchMenuBarView.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchMenuBarView.class, inj2310_WorkbenchMenuBarView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchMenuBarPresenter.class, WorkbenchMenuBarPresenter.class, inj2309_WorkbenchMenuBarPresenter_creational, inj2308_WorkbenchMenuBarPresenter, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(WorkbenchMenuBar.class, WorkbenchMenuBarPresenter.class, inj2309_WorkbenchMenuBarPresenter_creational, inj2308_WorkbenchMenuBarPresenter, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Workbench.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, Workbench.class, inj2312_Workbench_creational, inj2311_Workbench, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchEntryPoint.class, WorkbenchEntryPoint.class, inj2314_WorkbenchEntryPoint_creational, inj2313_WorkbenchEntryPoint, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DefaultFileEditorPresenterActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, true);
    injContext.addBean(AbstractWorkbenchEditorActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(WorkbenchEditorActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(WorkbenchActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(Activity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(RuntimeResource.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(Resource.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(AbstractActivity.class, DefaultFileEditorPresenterActivity.class, inj2316_DefaultFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1810418547, null, false);
    injContext.addBean(FileExplorerView.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(org.uberfire.client.editors.fileexplorer.FileExplorerPresenter.View.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, FileExplorerView.class, inj2319_FileExplorerView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(FileExplorerPresenter.class, FileExplorerPresenter.class, inj2318_FileExplorerPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj2320_ListWidgetProvider_creational, inj2233_ListWidgetProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj2320_ListWidgetProvider_creational, inj2233_ListWidgetProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(NotificationPopupsManager.class, NotificationPopupsManager.class, inj2322_NotificationPopupsManager_creational, inj2321_NotificationPopupsManager, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ShowcaseEntryPoint.class, ShowcaseEntryPoint.class, inj2324_ShowcaseEntryPoint_creational, inj2323_ShowcaseEntryPoint, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DotResourceType.class, DotResourceType.class, inj2326_DotResourceType_creational, inj2325_DotResourceType, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ResourceType.class, DotResourceType.class, inj2326_DotResourceType_creational, inj2325_DotResourceType, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HomePerspective.class, HomePerspective.class, inj2328_HomePerspective_creational, inj2327_HomePerspective, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(CommonsEntryPoint.class, CommonsEntryPoint.class, inj2330_CommonsEntryPoint_creational, inj2329_CommonsEntryPoint, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj2331_InstanceProvider_creational, inj2245_InstanceProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj2331_InstanceProvider_creational, inj2245_InstanceProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MetaFileEditorPresenter.class, MetaFileEditorPresenter.class, inj2333_MetaFileEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MarkdownView.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.markdown.viewer.MarkdownPresenter.View.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, MarkdownView.class, inj2336_MarkdownView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownPresenter.class, MarkdownPresenter.class, inj2335_MarkdownPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MarkdownPresenterActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, true);
    injContext.addBean(AbstractWorkbenchEditorActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(WorkbenchEditorActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(WorkbenchActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(Activity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(RuntimeResource.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(Resource.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(AbstractActivity.class, MarkdownPresenterActivity.class, inj2338_MarkdownPresenterActivity_creational, null, arrayOf_19635043Annotation_596385935, null, false);
    injContext.addBean(FileExplorerPresenterActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(WorkbenchScreenActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(WorkbenchActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(Activity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(RuntimeResource.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(Resource.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(AbstractActivity.class, FileExplorerPresenterActivity.class, inj2340_FileExplorerPresenterActivity_creational, null, arrayOf_19635043Annotation_46006661, null, false);
    injContext.addBean(CoreEntryPoint.class, CoreEntryPoint.class, inj2342_CoreEntryPoint_creational, inj2341_CoreEntryPoint, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(AnyResourceType.class, AnyResourceType.class, inj2344_AnyResourceType_creational, inj2343_AnyResourceType, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ResourceType.class, AnyResourceType.class, inj2344_AnyResourceType_creational, inj2343_AnyResourceType, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj2345_DisposerProvider_creational, inj2253_DisposerProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj2345_DisposerProvider_creational, inj2253_DisposerProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ResourceTypeManagerImpl.class, ResourceTypeManagerImpl.class, inj2347_ResourceTypeManagerImpl_creational, inj2346_ResourceTypeManagerImpl, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ResourceTypeManager.class, ResourceTypeManagerImpl.class, inj2347_ResourceTypeManagerImpl_creational, inj2346_ResourceTypeManagerImpl, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RepositoriesView.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.editors.repository.list.RepositoriesPresenter.View.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, RepositoriesView.class, inj2350_RepositoriesView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RepositoriesPresenter.class, RepositoriesPresenter.class, inj2349_RepositoriesPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RepositoriesPresenterActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(WorkbenchScreenActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(WorkbenchActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(Activity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(RuntimeResource.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(Resource.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(AbstractActivity.class, RepositoriesPresenterActivity.class, inj2352_RepositoriesPresenterActivity_creational, null, arrayOf_19635043Annotation_1824450930, null, false);
    injContext.addBean(MarkdownLiveView.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.markdown.editorlive.MarkdownLivePresenter.View.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, MarkdownLiveView.class, inj2355_MarkdownLiveView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownLivePresenter.class, MarkdownLivePresenter.class, inj2354_MarkdownLivePresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MultiPageEditorView.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, MultiPageEditorView.class, inj2357_MultiPageEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RepositoryEditorView.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.editors.repository.edit.RepositoryEditorPresenter.View.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, RepositoryEditorView.class, inj2360_RepositoryEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RepositoryEditorPresenter.class, RepositoryEditorPresenter.class, inj2359_RepositoryEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RepositoryEditorPresenterActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, true);
    injContext.addBean(AbstractWorkbenchEditorActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(WorkbenchEditorActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(WorkbenchActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(Activity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(RuntimeResource.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(Resource.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(AbstractActivity.class, RepositoryEditorPresenterActivity.class, inj2362_RepositoryEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1009268860, null, false);
    injContext.addBean(PanelHelperNorth.class, PanelHelperNorth.class, inj2364_PanelHelperNorth_creational, inj2363_PanelHelperNorth, arrayOf_19635043Annotation_304328246, null, true);
    injContext.addBean(PanelHelper.class, PanelHelperNorth.class, inj2364_PanelHelperNorth_creational, inj2363_PanelHelperNorth, arrayOf_19635043Annotation_304328246, null, false);
    injContext.addBean(PanelHelperSouth.class, PanelHelperSouth.class, inj2366_PanelHelperSouth_creational, inj2365_PanelHelperSouth, arrayOf_19635043Annotation_798604784, null, true);
    injContext.addBean(PanelHelper.class, PanelHelperSouth.class, inj2366_PanelHelperSouth_creational, inj2365_PanelHelperSouth, arrayOf_19635043Annotation_798604784, null, false);
    injContext.addBean(PanelHelperEast.class, PanelHelperEast.class, inj2368_PanelHelperEast_creational, inj2367_PanelHelperEast, arrayOf_19635043Annotation_259448057, null, true);
    injContext.addBean(PanelHelper.class, PanelHelperEast.class, inj2368_PanelHelperEast_creational, inj2367_PanelHelperEast, arrayOf_19635043Annotation_259448057, null, false);
    injContext.addBean(PanelHelperWest.class, PanelHelperWest.class, inj2370_PanelHelperWest_creational, inj2369_PanelHelperWest, arrayOf_19635043Annotation_1508307357, null, true);
    injContext.addBean(PanelHelper.class, PanelHelperWest.class, inj2370_PanelHelperWest_creational, inj2369_PanelHelperWest, arrayOf_19635043Annotation_1508307357, null, false);
    injContext.addBean(RootWorkbenchPanelView.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, true);
    injContext.addBean(WorkbenchPanelView.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(UberView.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(IsWidget.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(RequiresResize.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(ResizeComposite.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(Composite.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(IsRenderable.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(Widget.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(EventListener.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(HasAttachHandlers.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(HasHandlers.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(UIObject.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(HasVisibility.class, RootWorkbenchPanelView.class, inj2372_RootWorkbenchPanelView_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(RootWorkbenchPanelPresenter.class, RootWorkbenchPanelPresenter.class, inj2374_RootWorkbenchPanelPresenter_creational, null, arrayOf_19635043Annotation_1626376289, null, true);
    injContext.addBean(WorkbenchPanelPresenter.class, RootWorkbenchPanelPresenter.class, inj2374_RootWorkbenchPanelPresenter_creational, null, arrayOf_19635043Annotation_1626376289, null, false);
    injContext.addBean(PopupView.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(HasCloseHandlers.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, PopupView.class, inj2376_PopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MultipleActivitiesFoundPresenterActivity.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, true);
    injContext.addBean(AbstractPopupActivity.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(PopupActivity.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(Activity.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(RuntimeResource.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(Resource.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(AbstractActivity.class, MultipleActivitiesFoundPresenterActivity.class, inj2378_MultipleActivitiesFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_1374778235, null, false);
    injContext.addBean(MultiPageEditor.class, MultiPageEditor.class, inj2380_MultiPageEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(IsWidget.class, MultiPageEditor.class, inj2380_MultiPageEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj2381_RootPanelProvider_creational, inj2239_RootPanelProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj2381_RootPanelProvider_creational, inj2239_RootPanelProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(CreateRepositoryForm.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(HasCloseHandlers.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, CreateRepositoryForm.class, inj2383_CreateRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj2384_InitBallotProvider_creational, inj2247_InitBallotProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj2384_InitBallotProvider_creational, inj2247_InitBallotProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(TextEditorPresenter.class, TextEditorPresenter.class, inj2386_TextEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj2387_DataBinderProvider_creational, inj2243_DataBinderProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj2387_DataBinderProvider_creational, inj2243_DataBinderProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(TextEditorPresenterActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, true);
    injContext.addBean(AbstractWorkbenchEditorActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(WorkbenchEditorActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(WorkbenchActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(Activity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(RuntimeResource.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(Resource.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(AbstractActivity.class, TextEditorPresenterActivity.class, inj2389_TextEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1544573185, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj2390_RequestDispatcherProvider_creational, inj2237_RequestDispatcherProvider, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj2390_RequestDispatcherProvider_creational, inj2237_RequestDispatcherProvider, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownLiveEditorView.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(RequiresResize.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(org.uberfire.client.markdown.editorlive.MarkdownLiveEditorPresenter.View.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, MarkdownLiveEditorView.class, inj2393_MarkdownLiveEditorView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownLiveEditorPresenter.class, MarkdownLiveEditorPresenter.class, inj2392_MarkdownLiveEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MarkdownLiveEditorPresenterActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(WorkbenchScreenActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(WorkbenchActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(Activity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(RuntimeResource.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(Resource.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(AbstractActivity.class, MarkdownLiveEditorPresenterActivity.class, inj2395_MarkdownLiveEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_1967159266, null, false);
    injContext.addBean(VerticalSplitterPanel.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(SplitPanel.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ResizeComposite.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RequiresResize.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, VerticalSplitterPanel.class, inj2397_VerticalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(CloneRepositoryForm.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(PopupPanel.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesPopupEvents.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventPreview.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAnimation.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasCloseHandlers.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimplePanel.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasOneWidget.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AcceptsOneWidget.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Panel.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ForIsWidget.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasWidgets.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Iterable.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, CloneRepositoryForm.class, inj2399_CloneRepositoryForm_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownType.class, MarkdownType.class, inj2401_MarkdownType_creational, inj2400_MarkdownType, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ResourceType.class, MarkdownType.class, inj2401_MarkdownType_creational, inj2400_MarkdownType, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(NotificationPopupView.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DecoratedPopupPanel.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(PopupPanel.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesPopupEvents.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventPreview.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAnimation.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasCloseHandlers.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimplePanel.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasOneWidget.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AcceptsOneWidget.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Panel.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ForIsWidget.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasWidgets.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Iterable.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, NotificationPopupView.class, inj2403_NotificationPopupView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HomePerspectiveActivity.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, true);
    injContext.addBean(AbstractWorkbenchPerspectiveActivity.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(PerspectiveActivity.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(Activity.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(RuntimeResource.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(Resource.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(AbstractActivity.class, HomePerspectiveActivity.class, inj2405_HomePerspectiveActivity_creational, null, arrayOf_19635043Annotation_1623288266, null, false);
    injContext.addBean(TextBox.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(TextBoxBase.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ValueBoxBase.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasChangeHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasName.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasValue.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(TakesValue.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Target.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasText.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDirection.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsEditor.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(FocusWidget.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesClickEvents.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasClickHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasFocus.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Focusable.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasEnabled.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasDropHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasFocusHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasBlurHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, TextBox.class, inj2408_TextBox_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(PropertyEditor.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Composite.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
  }

  private void declareBeans_1() {
    injContext.addBean(HasAttachHandlers.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, PropertyEditor.class, inj2407_PropertyEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DataModelBrowser.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Composite.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, DataModelBrowser.class, inj2411_DataModelBrowser_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DataObjectEditor.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(Composite.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, DataObjectEditor.class, inj2412_DataObjectEditor_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DataModelEditorViewImpl.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DataModelEditorView.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, DataModelEditorViewImpl.class, inj2410_DataModelEditorViewImpl_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(DataModelEditorPresenter.class, DataModelEditorPresenter.class, inj2414_DataModelEditorPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(DataModelEditorPresenterActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(WorkbenchScreenActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(WorkbenchActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(Activity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(RuntimeResource.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(Resource.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(AbstractActivity.class, DataModelEditorPresenterActivity.class, inj2416_DataModelEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_224919741, null, false);
    injContext.addBean(WorkbenchPartView.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(View.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UberView.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RequiresResize.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimpleLayoutPanel.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ProvidesResize.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(SimplePanel.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasOneWidget.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(AcceptsOneWidget.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Panel.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ForIsWidget.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasWidgets.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Iterable.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, WorkbenchPartView.class, inj2419_WorkbenchPartView_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(WorkbenchPartPresenter.class, WorkbenchPartPresenter.class, inj2418_WorkbenchPartPresenter_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ActivityNotFoundPresenterActivity.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, true);
    injContext.addBean(AbstractPopupActivity.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(PopupActivity.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(Activity.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(RuntimeResource.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(Resource.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(AbstractActivity.class, ActivityNotFoundPresenterActivity.class, inj2421_ActivityNotFoundPresenterActivity_creational, null, arrayOf_19635043Annotation_918196602, null, false);
    injContext.addBean(MarkdownUtil.class, MarkdownUtil.class, inj2423_MarkdownUtil_creational, inj2422_MarkdownUtil, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(MetaFileEditorPresenterActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, true);
    injContext.addBean(AbstractWorkbenchEditorActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(WorkbenchEditorActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(WorkbenchActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(Activity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(RuntimeResource.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(Resource.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(AbstractActivity.class, MetaFileEditorPresenterActivity.class, inj2425_MetaFileEditorPresenterActivity_creational, null, arrayOf_19635043Annotation_882894192, null, false);
    injContext.addBean(HorizontalSplitterPanel.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(SplitPanel.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(ResizeComposite.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(RequiresResize.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Composite.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsRenderable.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(Widget.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(EventListener.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasAttachHandlers.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasHandlers.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(IsWidget.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(UIObject.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(HasVisibility.class, HorizontalSplitterPanel.class, inj2427_HorizontalSplitterPanel_creational, null, arrayOf_19635043Annotation_1909101200, null, false);
    injContext.addBean(MarkdownLivePresenterActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, true);
    injContext.addBean(AbstractWorkbenchScreenActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(WorkbenchScreenActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(WorkbenchActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(Activity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(RuntimeResource.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(Resource.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(AbstractWorkbenchActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(AbstractActivity.class, MarkdownLivePresenterActivity.class, inj2429_MarkdownLivePresenterActivity_creational, null, arrayOf_19635043Annotation_1920101153, null, false);
    injContext.addBean(TextResourceType.class, TextResourceType.class, inj2431_TextResourceType_creational, inj2430_TextResourceType, arrayOf_19635043Annotation_1909101200, null, true);
    injContext.addBean(ResourceType.class, TextResourceType.class, inj2431_TextResourceType_creational, inj2430_TextResourceType, arrayOf_19635043Annotation_1909101200, null, false);
  }

  private native static void _$1625293394_helperSouth(RootWorkbenchPanelView instance, PanelHelper value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::helperSouth = value;
  }-*/;

  private native static void _1452746254_workbench(WorkbenchEntryPoint instance, Workbench value) /*-{
    instance.@org.uberfire.client.WorkbenchEntryPoint::workbench = value;
  }-*/;

  private native static void _239180292_menuBar(AbstractWorkbenchPerspectiveActivity instance, WorkbenchMenuBar value) /*-{
    instance.@org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity::menuBar = value;
  }-*/;

  private native static void _$18744388_restorePlaceEvent(WorkbenchStatusBarPresenter instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter::restorePlaceEvent = value;
  }-*/;

  private native static void _$1740030057_notification(DataModelEditorPresenter instance, Event value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenter::notification = value;
  }-*/;

  private native static void _$1969214716_realPresenter(DefaultFileEditorPresenterActivity instance, DefaultFileEditorPresenter value) /*-{
    instance.@org.uberfire.client.editors.defaulteditor.DefaultFileEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$1625293394_helperWest(RootWorkbenchPanelView instance, PanelHelper value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::helperWest = value;
  }-*/;

  private native static Label _$1067079459_dataObjectPropertiesLabel(PropertyEditor instance) /*-{
    return instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::dataObjectPropertiesLabel;
  }-*/;

  private native static void _$1067079459_dataObjectPropertiesLabel(PropertyEditor instance, Label value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::dataObjectPropertiesLabel = value;
  }-*/;

  private native static void _$1421195439_view(FileExplorerPresenter instance, org.uberfire.client.editors.fileexplorer.FileExplorerPresenter.View value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenter::view = value;
  }-*/;

  private native static void _$1421195439_placeManager(FileExplorerPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenter::placeManager = value;
  }-*/;

  private native static void _138245081_realPresenter(MultipleActivitiesFoundPresenterActivity instance, MultipleActivitiesFoundPresenter value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenterActivity::realPresenter = value;
  }-*/;

  private native static TextBox _$1067079459_documentation(PropertyEditor instance) /*-{
    return instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::documentation;
  }-*/;

  private native static void _$1067079459_documentation(PropertyEditor instance, TextBox value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::documentation = value;
  }-*/;

  private native static void _$1022831358_wbServices(DefaultPlaceResolver instance, Caller value) /*-{
    instance.@org.uberfire.client.mvp.DefaultPlaceResolver::wbServices = value;
  }-*/;

  private native static void _1214998186_view(MultipleActivitiesFoundPresenter instance, org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter::view = value;
  }-*/;

  private native static void _1214998186_closePlaceEvent(MultipleActivitiesFoundPresenter instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter::closePlaceEvent = value;
  }-*/;

  private native static void _$1705636724_panelManager(CompassDropController instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::panelManager = value;
  }-*/;

  private native static void _740167622_realPresenter(DataModelEditorPresenterActivity instance, DataModelEditorPresenter value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _381543805_iocManager(ShowcaseEntryPoint instance, IOCBeanManager value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::iocManager = value;
  }-*/;

  private native static void _149710705_vfsServices(TextEditorPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.texteditor.TextEditorPresenter::vfsServices = value;
  }-*/;

  private native static void _153624969_dragController(WorkbenchDragAndDropManager instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::dragController = value;
  }-*/;

  private native static void _683332058_dndManager(WorkbenchPickupDragController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchPickupDragController::dndManager = value;
  }-*/;

  private native static void _1214998186_placeManager(MultipleActivitiesFoundPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter::placeManager = value;
  }-*/;

  private native static void _$76429077_beforeClosePlaceEvent(PanelManager instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::beforeClosePlaceEvent = value;
  }-*/;

  private native static void _$1462522111_placeManager(Workbench instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::placeManager = value;
  }-*/;

  private native static void _$18744388_view(WorkbenchStatusBarPresenter instance, org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter::view = value;
  }-*/;

  private native static void _$1327205249_factory(PanelHelperWest instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelHelperWest::factory = value;
  }-*/;

  private native static void _$2051264158_view(ActivityNotFoundPresenter instance, org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter::view = value;
  }-*/;

  private native static void _$1321361073_vfsService(CreateRepositoryForm instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.create.CreateRepositoryForm::vfsService = value;
  }-*/;

  private native static void _$1421195439_vfsService(FileExplorerPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenter::vfsService = value;
  }-*/;

  private native static void _$118440544_realPresenter(TextEditorPresenterActivity instance, TextEditorPresenter value) /*-{
    instance.@org.uberfire.client.editors.texteditor.TextEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$1112537939_event(CloneRepositoryForm instance, Event value) /*-{
    instance.@org.uberfire.client.editors.repository.clone.CloneRepositoryForm::event = value;
  }-*/;

  private native static void _$285107124_realPresenter(RepositoriesPresenterActivity instance, RepositoriesPresenter value) /*-{
    instance.@org.uberfire.client.editors.repository.list.RepositoriesPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _239180292_toolBarPresenter(AbstractWorkbenchPerspectiveActivity instance, WorkbenchToolBarPresenter value) /*-{
    instance.@org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity::toolBarPresenter = value;
  }-*/;

  private native static void _239180292_panelManager(AbstractWorkbenchPerspectiveActivity instance, PanelManager value) /*-{
    instance.@org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity::panelManager = value;
  }-*/;

  private native static void _363979058_event(MarkdownLiveEditorView instance, Event value) /*-{
    instance.@org.uberfire.client.markdown.editorlive.MarkdownLiveEditorView::event = value;
  }-*/;

  private native static void _$76429077_placeLostFocusEvent(PanelManager instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::placeLostFocusEvent = value;
  }-*/;

  private native static void _1798295605_factory(PanelHelperNorth instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelHelperNorth::factory = value;
  }-*/;

  private native static void _$1462522111_wbServices(Workbench instance, Caller value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::wbServices = value;
  }-*/;

  private native static DivElement _$1067079459_button(PropertyEditor instance) /*-{
    return instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::button;
  }-*/;

  private native static void _$1067079459_button(PropertyEditor instance, DivElement value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::button = value;
  }-*/;

  private native static void _40974972_toolBarUtils(WorkbenchToolBarPresenter instance, WorkbenchToolBarPresenterUtils value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::toolBarUtils = value;
  }-*/;

  private native static TextBox _$1067079459_name(PropertyEditor instance) /*-{
    return instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::name;
  }-*/;

  private native static void _$1067079459_name(PropertyEditor instance, TextBox value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.PropertyEditor::name = value;
  }-*/;

  private native static void _$2051264158_closePlaceEvent(ActivityNotFoundPresenter instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter::closePlaceEvent = value;
  }-*/;

  private native static void _$1462522111_dragController(Workbench instance, WorkbenchPickupDragController value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::dragController = value;
  }-*/;

  private native static void _1730935432_identity(ActivityManagerImpl instance, Identity value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::identity = value;
  }-*/;

  private native static void _$1321361073_event(CreateRepositoryForm instance, Event value) /*-{
    instance.@org.uberfire.client.editors.repository.create.CreateRepositoryForm::event = value;
  }-*/;

  private native static void _1730935432_iocManager(ActivityManagerImpl instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::iocManager = value;
  }-*/;

  private native static void _$76115871_view(MultiPageEditor instance, MultiPageEditorView value) /*-{
    instance.@org.uberfire.client.common.MultiPageEditor::view = value;
  }-*/;

  private native static void _$1625293394_dndManager(RootWorkbenchPanelView instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::dndManager = value;
  }-*/;

  private native static void _235547309_vfsServices(MarkdownPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.markdown.viewer.MarkdownPresenter::vfsServices = value;
  }-*/;

  private native static void _$76429077_factory(PanelManager instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::factory = value;
  }-*/;

  private native static void _1730935432_authzManager(ActivityManagerImpl instance, RuntimeAuthorizationManager value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::authzManager = value;
  }-*/;

  private native static void _1214998186_defaultPlaceResolver(MultipleActivitiesFoundPresenter instance, DefaultPlaceResolver value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter::defaultPlaceResolver = value;
  }-*/;

  private native static void _$76429077_selectPlaceEvent(PanelManager instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::selectPlaceEvent = value;
  }-*/;

  private native static void _381543805_rootService(ShowcaseEntryPoint instance, Caller value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::rootService = value;
  }-*/;

  private native static void _$1324720234_dataModelBrowser(DataModelEditorViewImpl instance, DataModelBrowser value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl::dataModelBrowser = value;
  }-*/;

  private native static void _$951038061_realPresenter(MetaFileEditorPresenterActivity instance, MetaFileEditorPresenter value) /*-{
    instance.@org.uberfire.client.editors.metafile.MetaFileEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$1708929533_closePlaceEvent(AbstractPopupActivity instance, Event value) /*-{
    instance.@org.uberfire.client.mvp.AbstractPopupActivity::closePlaceEvent = value;
  }-*/;

  private native static void _$292735039_menuBarUtils(WorkbenchMenuBarPresenter instance, WorkbenchMenuBarPresenterUtils value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::menuBarUtils = value;
  }-*/;

  private native static void _$1708929533_iocManager(AbstractPopupActivity instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.mvp.AbstractPopupActivity::iocManager = value;
  }-*/;

  private native static void _$1625293394_helperEast(RootWorkbenchPanelView instance, PanelHelper value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::helperEast = value;
  }-*/;

  private native static void _$1222153175_realPresenter(RepositoryEditorPresenterActivity instance, RepositoryEditorPresenter value) /*-{
    instance.@org.uberfire.client.editors.repository.edit.RepositoryEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _153624969_factory(WorkbenchDragAndDropManager instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.WorkbenchDragAndDropManager::factory = value;
  }-*/;

  private native static void _381543805_manager(ShowcaseEntryPoint instance, IOCBeanManager value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::manager = value;
  }-*/;

  private native static void _407597655_realPresenter(MarkdownLivePresenterActivity instance, MarkdownLivePresenter value) /*-{
    instance.@org.uberfire.client.markdown.editorlive.MarkdownLivePresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$238379932_vfsServices(MetaFileEditorPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.metafile.MetaFileEditorPresenter::vfsServices = value;
  }-*/;

  private native static void _$1112537939_rootService(CloneRepositoryForm instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.clone.CloneRepositoryForm::rootService = value;
  }-*/;

  private native static void _$1462522111_iocManager(Workbench instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::iocManager = value;
  }-*/;

  private native static void _1452746254_pathChangedEvent(WorkbenchEntryPoint instance, Event value) /*-{
    instance.@org.uberfire.client.WorkbenchEntryPoint::pathChangedEvent = value;
  }-*/;

  private native static void _239180292_wbServices(AbstractWorkbenchPerspectiveActivity instance, Caller value) /*-{
    instance.@org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity::wbServices = value;
  }-*/;

  private native static void _1906672860_realPresenter(MarkdownPresenterActivity instance, MarkdownPresenter value) /*-{
    instance.@org.uberfire.client.markdown.viewer.MarkdownPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$292735039_placeManager(WorkbenchMenuBarPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::placeManager = value;
  }-*/;

  private native static void _$1729318371_rootService(RepositoriesPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.list.RepositoriesPresenter::rootService = value;
  }-*/;

  private native static void _$1462522111_panelManager(Workbench instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::panelManager = value;
  }-*/;

  private native static void _$1988003627_vfsServices(DefaultFileEditorPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.defaulteditor.DefaultFileEditorPresenter::vfsServices = value;
  }-*/;

  private native static void _$1327745331_factory(PanelHelperEast instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelHelperEast::factory = value;
  }-*/;

  private native static void _$1729318371_vfsService(RepositoriesPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.list.RepositoriesPresenter::vfsService = value;
  }-*/;

  private native static void _$1207394361_realPresenter(HomePerspectiveActivity instance, HomePerspective value) /*-{
    instance.@org.jbpm.datamodeler.client.perspectives.HomePerspectiveActivity::realPresenter = value;
  }-*/;

  private native static void _$1324720234_dataObjectEditor(DataModelEditorViewImpl instance, DataObjectEditor value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl::dataObjectEditor = value;
  }-*/;

  private native static void _$2051264158_placeManager(ActivityNotFoundPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenter::placeManager = value;
  }-*/;

  private native static void _$1757102468_workbenchPartCloseEvent(PlaceManagerImpl instance, Event value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartCloseEvent = value;
  }-*/;

  private native static void _$1729318371_iocManager(RepositoriesPresenter instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.editors.repository.list.RepositoriesPresenter::iocManager = value;
  }-*/;

  private native static void _$1705636724_workbenchPartDroppedEvent(CompassDropController instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::workbenchPartDroppedEvent = value;
  }-*/;

  private native static void _239180292_placeManager(AbstractWorkbenchPerspectiveActivity instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.mvp.AbstractWorkbenchPerspectiveActivity::placeManager = value;
  }-*/;

  private native static void _$76429077_placeGainFocusEvent(PanelManager instance, Event value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::placeGainFocusEvent = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$1705636724_dndManager(CompassDropController instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.dnd.CompassDropController::dndManager = value;
  }-*/;

  private native static void _1174169399_iocManager(DefaultBeanFactory instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.DefaultBeanFactory::iocManager = value;
  }-*/;

  private native static void _$1757102468_workbenchPartLostFocusEvent(PlaceManagerImpl instance, Event value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartLostFocusEvent = value;
  }-*/;

  private native static void _$76429077_statusBar(PanelManager instance, WorkbenchStatusBarPresenter value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::statusBar = value;
  }-*/;

  private native static void _$1757102468_workbenchPartBeforeCloseEvent(PlaceManagerImpl instance, Event value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::workbenchPartBeforeCloseEvent = value;
  }-*/;

  private native static void _$2041313647_realPresenter(ActivityNotFoundPresenterActivity instance, ActivityNotFoundPresenter value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.notfound.ActivityNotFoundPresenterActivity::realPresenter = value;
  }-*/;

  private native static HorizontalPanel _$1324720234_contentsPanel(DataModelEditorViewImpl instance) /*-{
    return instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl::contentsPanel;
  }-*/;

  private native static void _$1324720234_contentsPanel(DataModelEditorViewImpl instance, HorizontalPanel value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl::contentsPanel = value;
  }-*/;

  private native static void _$1462522111_dndManager(Workbench instance, WorkbenchDragAndDropManager value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::dndManager = value;
  }-*/;

  private native static void _1214998186_activityManager(MultipleActivitiesFoundPresenter instance, ActivityManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.popups.activities.multiple.MultipleActivitiesFoundPresenter::activityManager = value;
  }-*/;

  private native static void _$1112537939_vfsService(CloneRepositoryForm instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.clone.CloneRepositoryForm::vfsService = value;
  }-*/;

  private native static void _1135152903_bus(SecurityEntryPoint instance, MessageBus value) /*-{
    instance.@org.uberfire.security.client.SecurityEntryPoint::bus = value;
  }-*/;

  private native static void _$746838216_iocManager(NotificationPopupsManager instance, IOCBeanManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.notifications.NotificationPopupsManager::iocManager = value;
  }-*/;

  private native static void _381543805_placeManager(ShowcaseEntryPoint instance, PlaceManager value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::placeManager = value;
  }-*/;

  private native static void _$292735039_view(WorkbenchMenuBarPresenter instance, org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::view = value;
  }-*/;

  private native static void _$1421195439_pathChangedEvent(FileExplorerPresenter instance, Event value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenter::pathChangedEvent = value;
  }-*/;

  private native static void _565882618_vfsService(RepositoryEditorPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.edit.RepositoryEditorPresenter::vfsService = value;
  }-*/;

  private native static void _$1462522111_toolBarPresenter(Workbench instance, WorkbenchToolBarPresenter value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::toolBarPresenter = value;
  }-*/;

  private native static void _1730935432_activityBeansCache(ActivityManagerImpl instance, ActivityBeansCache value) /*-{
    instance.@org.uberfire.client.mvp.ActivityManagerImpl::activityBeansCache = value;
  }-*/;

  private native static void _381543805_activityManager(ShowcaseEntryPoint instance, ActivityManager value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::activityManager = value;
  }-*/;

  private native static void _$1625293394_factory(RootWorkbenchPanelView instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::factory = value;
  }-*/;

  private native static void _$396060566_realPresenter(MarkdownLiveEditorPresenterActivity instance, MarkdownLiveEditorPresenter value) /*-{
    instance.@org.uberfire.client.markdown.editorlive.MarkdownLiveEditorPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$1324720234_propertyEditor(DataModelEditorViewImpl instance, PropertyEditor value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorViewImpl::propertyEditor = value;
  }-*/;

  private native static void _$1321361073_rootService(CreateRepositoryForm instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.repository.create.CreateRepositoryForm::rootService = value;
  }-*/;

  private native static void _40974972_view(WorkbenchToolBarPresenter instance, org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter.View value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::view = value;
  }-*/;

  private native static void _$1421195439_rootService(FileExplorerPresenter instance, Caller value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenter::rootService = value;
  }-*/;

  private native static void _1189133696_realPresenter(FileExplorerPresenterActivity instance, FileExplorerPresenter value) /*-{
    instance.@org.uberfire.client.editors.fileexplorer.FileExplorerPresenterActivity::realPresenter = value;
  }-*/;

  private native static void _$1740030057_view(DataModelEditorPresenter instance, DataModelEditorView value) /*-{
    instance.@org.jbpm.datamodeler.editor.client.editors.DataModelEditorPresenter::view = value;
  }-*/;

  private native static void _$1625293394_helperNorth(RootWorkbenchPanelView instance, PanelHelper value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::helperNorth = value;
  }-*/;

  private native static void _$1462522111_menuBarPresenter(Workbench instance, WorkbenchMenuBarPresenter value) /*-{
    instance.@org.uberfire.client.workbench.Workbench::menuBarPresenter = value;
  }-*/;

  private native static void _1047951015_mapper(PlaceHistoryHandler instance, PlaceRequestHistoryMapper value) /*-{
    instance.@org.uberfire.client.mvp.PlaceHistoryHandler::mapper = value;
  }-*/;

  private native static void _381543805_menubar(ShowcaseEntryPoint instance, WorkbenchMenuBar value) /*-{
    instance.@org.jbpm.datamodeler.client.ShowcaseEntryPoint::menubar = value;
  }-*/;

  private native static void _$1625293394_panelManager(RootWorkbenchPanelView instance, PanelManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::panelManager = value;
  }-*/;

  private native static void _40974972_placeManager(WorkbenchToolBarPresenter instance, PlaceManager value) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::placeManager = value;
  }-*/;

  private native static void _1802916093_factory(PanelHelperSouth instance, BeanFactory value) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelHelperSouth::factory = value;
  }-*/;

  private native static void _$1757102468_defaultPlaceResolver(PlaceManagerImpl instance, DefaultPlaceResolver value) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::defaultPlaceResolver = value;
  }-*/;

  private native static void _$1708929533_popup(AbstractPopupActivity instance, PopupView value) /*-{
    instance.@org.uberfire.client.mvp.AbstractPopupActivity::popup = value;
  }-*/;

  public native static EventBus _$1757102468_produceEventBus(PlaceManagerImpl instance) /*-{
    return instance.@org.uberfire.client.mvp.PlaceManagerImpl::produceEventBus()();
  }-*/;

  public native static void _$18744388_onWorkbenchPartClose(WorkbenchStatusBarPresenter instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter::onWorkbenchPartClose(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _$18744388_init(WorkbenchStatusBarPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.widgets.statusbar.WorkbenchStatusBarPresenter::init()();
  }-*/;

  public native static void _$76429077_onSelectPlaceEvent(PanelManager instance, SelectPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onSelectPlaceEvent(Lorg/uberfire/client/workbench/widgets/events/SelectPlaceEvent;)(a0);
  }-*/;

  public native static void _$76429077_onClosePlaceEvent(PanelManager instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onClosePlaceEvent(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _$76429077_onDropPlaceEvent(PanelManager instance, DropPlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onDropPlaceEvent(Lorg/uberfire/client/workbench/widgets/events/DropPlaceEvent;)(a0);
  }-*/;

  public native static void _$76429077_onMinimizePlaceEvent(PanelManager instance, MinimizePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onMinimizePlaceEvent(Lorg/uberfire/client/workbench/widgets/events/MinimizePlaceEvent;)(a0);
  }-*/;

  public native static void _$76429077_onRestorePlaceEvent(PanelManager instance, RestorePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onRestorePlaceEvent(Lorg/uberfire/client/workbench/widgets/events/RestorePlaceEvent;)(a0);
  }-*/;

  public native static void _$76429077_onChangeTitleWidgetEvent(PanelManager instance, ChangeTitleWidgetEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.PanelManager::onChangeTitleWidgetEvent(Lorg/uberfire/client/workbench/widgets/events/ChangeTitleWidgetEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartBeforeClose(PlaceManagerImpl instance, BeforeClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartBeforeClose(Lorg/uberfire/client/workbench/widgets/events/BeforeClosePlaceEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartClose(PlaceManagerImpl instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartClose(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartOnFocus(PlaceManagerImpl instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onWorkbenchPartLostFocus(PlaceManagerImpl instance, PlaceLostFocusEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onWorkbenchPartLostFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceLostFocusEvent;)(a0);
  }-*/;

  public native static void _$1757102468_onSavePlace(PlaceManagerImpl instance, SavePlaceEvent a0) /*-{
    instance.@org.uberfire.client.mvp.PlaceManagerImpl::onSavePlace(Lorg/uberfire/client/workbench/widgets/events/SavePlaceEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartClose(WorkbenchToolBarPresenter instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartClose(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartLostFocus(WorkbenchToolBarPresenter instance, PlaceLostFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartLostFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceLostFocusEvent;)(a0);
  }-*/;

  public native static void _40974972_onWorkbenchPartOnFocus(WorkbenchToolBarPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.toolbar.WorkbenchToolBarPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$292735039_onWorkbenchPartClose(WorkbenchMenuBarPresenter instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onWorkbenchPartClose(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _$292735039_onWorkbenchPartLostFocus(WorkbenchMenuBarPresenter instance, PlaceLostFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onWorkbenchPartLostFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceLostFocusEvent;)(a0);
  }-*/;

  public native static void _$292735039_onWorkbenchPartOnFocus(WorkbenchMenuBarPresenter instance, PlaceGainFocusEvent a0) /*-{
    instance.@org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter::onWorkbenchPartOnFocus(Lorg/uberfire/client/workbench/widgets/events/PlaceGainFocusEvent;)(a0);
  }-*/;

  public native static void _$1462522111_bootstrap(Workbench instance) /*-{
    instance.@org.uberfire.client.workbench.Workbench::bootstrap()();
  }-*/;

  public native static void _$1625293394_setupDragAndDrop(RootWorkbenchPanelView instance) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelView::setupDragAndDrop()();
  }-*/;

  public native static void _193002815_init(RootWorkbenchPanelPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.RootWorkbenchPanelPresenter::init()();
  }-*/;

  public native static void _$1708929533_onClose(AbstractPopupActivity instance, ClosePlaceEvent a0) /*-{
    instance.@org.uberfire.client.mvp.AbstractPopupActivity::onClose(Lorg/uberfire/client/workbench/widgets/events/ClosePlaceEvent;)(a0);
  }-*/;

  public native static void _1456584152_init(WorkbenchPartPresenter instance) /*-{
    instance.@org.uberfire.client.workbench.widgets.panels.WorkbenchPartPresenter::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    final CreationalCallback<Identity> var11 = new CreationalCallback<Identity>() {
      public Identity getInstance(CreationalContext pContext) {
        Identity var11 = inj2279_SecurityEntryPoint.currentUser();
        context.addBean(context.getBeanReference(Identity.class, arrayOf_19635043Annotation_1909101200), var11);
        return var11;
      }
    };
    final CreationalCallback<EventBus> var44 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var44 = _$1757102468_produceEventBus(inj2292_PlaceManagerImpl);
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_1909101200), var44);
        return var44;
      }
    };
    declareBeans_0();
    declareBeans_1();
    return injContext;
  }
}