package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 17/12/2012
 */
public interface EntityFrameChangedEvent<E extends OWLEntity> extends Event {

    ProjectId projectId();

    UserId userId();

    E entity();
}
