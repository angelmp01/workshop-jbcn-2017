@Grab('org.gitlab4j:gitlab4j-api:4.2.0')
import org.gitlab4j.api.*

String call(String projectName, String mergeid) {
	println "Get state of merge request[$projectName][$mergeid]"
	
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
  
  def merge_id = null
  
  for(def mergeRequest : mergeRequestApi.getMergeRequests(projectId)){
    println "merge request[${mergeRequest.iid}][[${mergeRequest.id}]"
    
    if(mergeid.equals("${mergeRequest.iid}")) {
       merge_id = mergeRequest.getId()
       break
    }       		
	}
  
  println "merge request id[${merge_id}]"      

  String state = null
  
  try {
    state = mergeRequestApi.getMergeRequest(projectId, merge_id).getState()
  } catch(Exception e) {
    //Ignore.
    println "Error to get the state of merge request[$projectId][$mergeid][$merge_id]: $e"
  }
  
	return state
}