package com.amazingco.organization;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name="organization_nodes")
@Data
public class OrganizationNodes {
    @Id
    @Column(name = "node_id")
    private Long nodeId;

    @Column(name = "node_name")
    private String nodeName;

    @Column(name = "height")
    private Integer height;

    @Column(name = "root_node")
    private Boolean rootNode;

    @Column(name = "path", nullable = false, columnDefinition = "ltree")
    private String path;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(final Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(final String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    public Boolean getRootNode() {
        return rootNode;
    }

    public void setRootNode(final Boolean rootNode) {
        this.rootNode = rootNode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
