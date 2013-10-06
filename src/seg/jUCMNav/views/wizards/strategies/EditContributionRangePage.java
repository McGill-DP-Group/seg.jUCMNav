package seg.jUCMNav.views.wizards.strategies;

import grl.ContributionChange;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;

import seg.jUCMNav.JUCMNavPlugin;
import seg.jUCMNav.Messages;
import urn.URNspec;

/**
 * Page which allows you to edit an ContributionRange. 
 * 
 * @author jkealey
 */

public class EditContributionRangePage extends WizardPage {

    private Shell shell;
    private Composite container;
    private URNspec urn;
    private ContributionChange change;
    private Text startValue;
    private Text endValue;
    private Text stepValue;
    private Canvas cv;
    private boolean containsErrors = false;
    private IWorkbenchPage workbenchPage;
    private boolean updating = false;

    /**
     * The selection contains urn model elements.
     * 
     * @param workbenchPage
     * @param urn
     * 
     * @param selection
     * @param defaultSelected
     */
    public EditContributionRangePage(IWorkbenchPage workbenchPage, URNspec urn, ContributionChange change) {
        super("wizardPage"); //$NON-NLS-1$
        this.setImageDescriptor(JUCMNavPlugin.getImageDescriptor("icons/perspectiveIcon.gif")); //$NON-NLS-1$
        this.change = change;
        this.urn = urn;
        this.workbenchPage = workbenchPage;

        setTitle(Messages.getString("EditContributionRangePage.EditContributionRange")); //$NON-NLS-1$
        setDescription(Messages.getString("EditContributionRangePage.EditRangeValues")); //$NON-NLS-1$

    }

    public ContributionChange getContributionChange() {
        return change;
    }

    public void setContributionChange(ContributionChange change) {
        this.change = change;
    }

    /**
     * Creates the page.
     */
    public void createControl(Composite parent) {

        //PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, "seg.jUCMNav.edit_ContributionChangeRange"); //$NON-NLS-1$

        container = new Composite(parent, SWT.NULL);
        shell = container.getShell();
        GridLayout containerLayout = new GridLayout();
        containerLayout.numColumns = 5;
        container.setLayout(containerLayout);

        Label startLabel = new Label(container, SWT.NULL);
        startLabel.setText(Messages.getString("EditContributionRangePage.Start")); //$NON-NLS-1$

        startValue = new Text(container, SWT.BORDER);
        startValue.setText("0"); //$NON-NLS-1$
        GridData gd4 = new GridData();
        gd4.horizontalSpan = 4;
        gd4.widthHint = 50;
        startValue.setLayoutData(gd4);
        startValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        Label endLabel = new Label(container, SWT.NULL);
        endLabel.setText(Messages.getString("EditContributionRangePage.End")); //$NON-NLS-1$

        endValue = new Text(container, SWT.BORDER);
        endValue.setText("0"); //$NON-NLS-1$
        GridData gd5 = new GridData();
        gd5.horizontalSpan = 4;
        gd5.widthHint = 50;
        endValue.setLayoutData(gd4);
        endValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        Label stepLabel = new Label(container, SWT.NULL);
        stepLabel.setText(Messages.getString("EditContributionRangePage.Step")); //$NON-NLS-1$

        stepValue = new Text(container, SWT.BORDER);
        stepValue.setText("0"); //$NON-NLS-1$
        GridData gd6 = new GridData();
        gd6.horizontalSpan = 4;
        gd6.widthHint = 50;
        stepValue.setLayoutData(gd4);
        stepValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });

        updating = true;
        initialize();
        dialogChanged();
        updating = false;
        setControl(container);

    }

    /**
	 * 
	 */
    private void dialogChanged() {
        if (!updating) {
            if (isValidInteger(startValue.getText()) != null) { //$NON-NLS-1$
                setErrorMessage(Messages.getString("EditContributionRangePage.StartMustBeInteger")); //$NON-NLS-1$
                containsErrors = true;
            } else if (isValidInteger(endValue.getText()) != null) { //$NON-NLS-1$
                setErrorMessage(Messages.getString("EditContributionRangePage.EndMustBeInteger")); //$NON-NLS-1$
                containsErrors = true;
            } else if (isValidInteger(stepValue.getText()) != null) { //$NON-NLS-1$
                setErrorMessage(Messages.getString("EditContributionRangePage.StepMustBeInteger")); //$NON-NLS-1$
                containsErrors = true;
            } else {

                int start = getStartValue();
                int end = Integer.parseInt(endValue.getText());
                int step = Integer.parseInt(stepValue.getText());

                if (step == 0 || (end - start) * step < 0) {
                    setErrorMessage(Messages.getString("EditContributionRangePage.GivenThisStepEndWillNotBeReached")); //$NON-NLS-1$
                    containsErrors = true;
                } else {
                    setErrorMessage(null);
                    containsErrors = false;
                }
            }
        }
    }

    public int getStartValue() {
        if (isValidInteger(startValue.getText()) == null)
            return Integer.parseInt(startValue.getText());
        else
            return 0;
    }
    
    public int getEndValue() {
        if (isValidInteger(endValue.getText()) == null)
            return Integer.parseInt(endValue.getText());
        else
            return 0;
    }
    
    public int getStepValue() {
        if (isValidInteger(stepValue.getText()) == null)
            return Integer.parseInt(stepValue.getText());
        else
            return 1;
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */
    private void initialize() {
        if (change == null || change.getContribRange() == null) {
            startValue.setText("0"); //$NON-NLS-1$
            endValue.setText("100"); //$NON-NLS-1$
            stepValue.setText("5"); //$NON-NLS-1$
        } else {
            startValue.setText(Integer.toString(change.getContribRange().getStart()));
            endValue.setText(Integer.toString(change.getContribRange().getEnd()));
            stepValue.setText(Integer.toString(change.getContribRange().getStep()));
        }
    }

    /**
     * Dealing with "integer" in text widget
     */
    public String isValidInteger(Object value) {
        int intValue = 0;
        try {
            if (value.toString().length() == 0)
                throw new NumberFormatException();
            intValue = Integer.parseInt(value.toString());
            
            if (Math.abs(intValue) > 100 )
                return Messages.getString("EditContributionRangePage.ValueShouldBeInRange"); //$NON-NLS-1$
            return null;
        } catch (NumberFormatException e) {
            return Messages.getString("EObjectPropertySource.notValidNumber"); //$NON-NLS-1$
        }
    }

    /**
     * Updates the status of the window
     * 
     * @param message
     *            the error message or null if no error message.
     */
    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }
}
