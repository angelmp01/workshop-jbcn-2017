@Grab('org.gitlab4j:gitlab4j-api:4.2.0')
import org.gitlab4j.api.*
import utils.MergeRequestApi2

String call(String projectName, String mergeid) {
	println "Get target branch of merge request[$projectName][$mergeid]"
	
	GitLabApi gitLabApi = GitLabApi.login(GitLabApi.ApiVersion.V4, 'http://gitlab', 'root', 'jBCNConf2017');
	
	ProjectApi projectApi  = gitLabApi.getProjectApi()
    
  def projectId = null
  
  for(def project : projectApi.getProjects()) {
      if(projectName.equals(project.getName())) {
          projectId = project.getId()
          break
      }
  }
	
	MergeRequestApi mergeRequestApi = gitLabApi.getMergeRequestApi()
  
  /*
  def merge_id = null
  
  for(def mergeRequest : mergeRequestApi.getMergeRequests(projectId)){
    println "merge request[$mergeid][${mergeRequest.iid}][${mergeRequest.id}]"
    
    if(mergeid == "${mergeRequest.iid}") {
       merge_id = mergeRequest.getId()
       break
    }       		
	}
  
  println "merge request id[${merge_id}]"
   */
   
  String target = null
  
  try {
    target = mergeRequestApi.getMergeRequest(projectId, mergeid.toInteger())).getTargetBranch()
  } catch(Exception e) {
    //Ignore.
    println "Error to get target branch of merge request[$projectId][$mergeid]: $e"
  }

	return target
}