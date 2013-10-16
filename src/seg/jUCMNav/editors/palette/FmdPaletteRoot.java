package seg.jUCMNav.editors.palette;

import grl.Decomposition;
import grl.Dependency;
import grl.IntentionalElementRef;
import grl.IntentionalElementType;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.Messages;
import seg.jUCMNav.editors.UCMNavMultiPageEditor;
import seg.jUCMNav.editors.palette.tools.BaseConnectionCreationToolEntry;
import seg.jUCMNav.editors.palette.tools.URNElementCreationEntry;
import seg.jUCMNav.model.ModelCreationFactory;
import urncore.Comment;

public class FmdPaletteRoot extends UcmPaletteRoot {

    /**
     * Creates a new FmdPaletteRoot.
     */
    public FmdPaletteRoot(UCMNavMultiPageEditor parent) {
        super(parent);
    }
    
    /**
     * Builds the palette entries.
     */
    protected void buildPalette() {
        keyboardMapping = new HashMap();
        // a group of default control tools
        PaletteGroup controls = new PaletteGroup(Messages.getString("FmdPaletteRoot.controls")); //$NON-NLS-1$

        // the selection tool; default tool
        ToolEntry tool = new SelectionToolEntry();
        controls.add(tool);
        setDefaultEntry(tool);

        ToolEntry entry = new URNElementCreationEntry(
                "Comment", Messages.getString("FmdPaletteRoot.CreateAComment"), Comment.class, new ModelCreationFactory(getURNspec(), Comment.class), JUCMNavPlugin.getImageDescriptor("icons/Comment16.gif"), ImageDescriptor.createFromFile( //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                                JUCMNavPlugin.class, "icons/Comment24.gif")); //$NON-NLS-1$
        controls.add(entry);
        keyboardMapping.put("q", entry); //$NON-NLS-1$
        
        add(controls);

        //A group of links
        PaletteDrawer linksDrawer = new PaletteDrawer(Messages.getString("FmdPaletteRoot.links")); //$NON-NLS-1$

        // Add a decomposition
        entry = new BaseConnectionCreationToolEntry(
                Messages.getString("FmdPaletteRoot.decomposition"), Messages.getString("FmdPaletteRoot.createDecomposition"), new ModelCreationFactory(getURNspec(), Decomposition.class), //$NON-NLS-1$ //$NON-NLS-2$
                JUCMNavPlugin.getImageDescriptor("icons/Decomposition16.gif"), ImageDescriptor.createFromFile( //$NON-NLS-1$
                        JUCMNavPlugin.class, "icons/Decomposition24.gif")); //$NON-NLS-1$
        linksDrawer.add(entry);
        keyboardMapping.put("d", entry); //$NON-NLS-1$
        
        // Add a mandatory
        entry = new BaseConnectionCreationToolEntry(
                Messages.getString("FmdPaletteRoot.mandatory"), Messages.getString("FmdPaletteRoot.createMandatory"), new ModelCreationFactory(getURNspec(), Dependency.class), //$NON-NLS-1$ //$NON-NLS-2$
                JUCMNavPlugin.getImageDescriptor("icons/Mandatory16.gif"), ImageDescriptor.createFromFile( //$NON-NLS-1$
                        JUCMNavPlugin.class, "icons/Mandatory24.gif")); //$NON-NLS-1$
        linksDrawer.add(entry);
        
        add(linksDrawer);
        
        //A group of elements
        PaletteDrawer elementsDrawer = new PaletteDrawer(Messages.getString("FmdPaletteRoot.elements")); //$NON-NLS-1$
        
        entry = new URNElementCreationEntry(
                Messages.getString("FmdPaletteRoot.task"), Messages.getString("FmdPaletteRoot.createTask"), IntentionalElementRef.class, new ModelCreationFactory(getURNspec(), IntentionalElementRef.class, //$NON-NLS-1$ //$NON-NLS-2$
                        IntentionalElementType.TASK), JUCMNavPlugin.getImageDescriptor("icons/Task16.gif"), ImageDescriptor.createFromFile( //$NON-NLS-1$
                        JUCMNavPlugin.class, "icons/Task24.gif")); //$NON-NLS-1$
        elementsDrawer.add(entry);
        keyboardMapping.put("t", entry); //$NON-NLS-1$
        
        add(elementsDrawer);
    }
    
    /**
     * Does a palette entry exists with this label
     * 
     * @param name
     * @return
     */
    protected boolean contains(String name) {
        return getEntry(name) != null;
    }
    
    /**
     * Find a palette entry from a label name
     * 
     * @param label
     * @return
     */
    protected PaletteEntry getEntry(String label) {
        for (Iterator iterator = getChildren().iterator(); iterator.hasNext();) {
            Object o = (Object) iterator.next();
            if (o instanceof PaletteDrawer) {
                if (((PaletteDrawer) o).getLabel().equals(label))
                    return (PaletteDrawer) o;
            }
        }
        return null;
    }

}
