@Grab('org.gitlab4j:gitlab4j-api:4.2.0')
import org.gitlab4j.api.*

String call(String projectName, String mergeid) {
	println "Get state of merge request[$mergeid]"
	
	GitLabApi gitLabApi = GitLabApi.login('http://gitlab', 'root', 'jBCNConf2017');
	
	ProjectApi projectApi  = gitLabApi.getProjectApi()
    
    def projectId = null
    
    for(def project : projectApi.getProjects()) {
        if(projectName.equals(project.getName())) {
            projectId = project.getId()
            break
        }
    }

	MergeRequestApi mergeRequestApi = gitLabApi.getMergeRequestApi()

	return mergeRequestApi.getMergeRequest(projectId, mergeid.toInteger()).getState()
}