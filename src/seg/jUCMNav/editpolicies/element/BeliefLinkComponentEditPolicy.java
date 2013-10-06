package seg.jUCMNav.editpolicies.element;

import grl.BeliefLink;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import seg.jUCMNav.model.commands.delete.internal.RemoveBeliefLinkCommand;

/**
 * ComponentEditPolicy for Belief Link. Return the delete command for a BeliefLink
 * 
 * @author Jean-Fran�ois Roy
 * 
 */
public class BeliefLinkComponentEditPolicy extends ComponentEditPolicy {

    /**
     * 
     * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#getDeleteCommand(org.eclipse.gef.requests.GroupRequest)
     */
    protected Command getDeleteCommand(GroupRequest request) {

        BeliefLink link = (BeliefLink) getHost().getModel();

        return new RemoveBeliefLinkCommand(link);
    }
}
