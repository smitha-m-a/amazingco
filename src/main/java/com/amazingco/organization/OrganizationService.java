package com.amazingco.organization;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationNodesRepo organizationNodesRepo;

    public OrganizationService(final OrganizationNodesRepo organizationNodesRepo) {
        this.organizationNodesRepo = organizationNodesRepo;
    }

    List<OrganizationNodes> findAllChildrenNodes(final String nodeName) {
        final String pathToSearch = "*." + nodeName + ".*";
        return organizationNodesRepo.findAllChildrenNodes(pathToSearch);
    }

    void moveNode(final String nodeName, final String parentNode) {
        final OrganizationNodes sourceNode = organizationNodesRepo.findNodeByName(nodeName);
        final OrganizationNodes destinationNode = organizationNodesRepo.findNodeByName(parentNode);

        if (sourceNode == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Source node not found with name: " + nodeName);
        }

        if (destinationNode == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parent node not found with name: " + parentNode);
        }

        if (destinationNode.getPath().contains(nodeName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "This operation is not supported. Cannot move a node under its own child.");
        }

        organizationNodesRepo.moveNodeToDifferentParent(destinationNode.getPath(), sourceNode.getPath(), sourceNode.getHeight());
    }
}
