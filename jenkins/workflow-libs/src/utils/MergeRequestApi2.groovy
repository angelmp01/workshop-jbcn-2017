package utils

import org.gitlab4j.api.*
import org.gitlab4j.api.models.*
import org.gitlab4j.api.utils.*
import org.gitlab4j.api.webhook.*

import javax.ws.rs.core.Form
import javax.ws.rs.core.GenericType
import javax.ws.rs.core.Response

import org.gitlab4j.api.models.MergeRequest;

class MergeRequestApi2 extends MergeRequestApi {

    public MergeRequestApi2(GitLabApi gitLabApi) {
        super(gitLabApi);
    }
    
    public void accept(Integer projectId, Integer mergeRequestId) {
        Form formData = new Form();
        
        addFormParam(formData, "project_id", projectId, true);
        addFormParam(formData, "iid", mergeRequestId, true);
        addFormParam(formData, "should_remove_source_branch", true, false);
        
        Response response = put(Response.Status.OK, formData.asMap(), "projects", projectId, "merge_requests", mergeRequestId, 'merge');
    }
    
    public void delete(Integer projectId, Integer mergeRequestId) {
        Response response = delete(Response.Status.NO_CONTENT, null, "projects", projectId, "merge_requests", mergeRequestId);
    }   
    
    public String getState(Integer projectId, Integer mergeRequestId) {
      Response response = get(Response.Status.OK, null, "projects", projectId, "merge_request", mergeRequestId);
      
      return "$response"
    } 
}
