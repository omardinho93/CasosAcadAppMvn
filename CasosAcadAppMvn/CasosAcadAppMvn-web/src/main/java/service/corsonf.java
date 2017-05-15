/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.HashSet;
import java.util.Set;
import com.thetransactioncompany.cors.CORSFilter;

/**
 *
 * @author delsas
 */
public class corsonf extends CORSFilter{
	
	
	
	public final boolean allowGenericHttpRequests=true;

	public final boolean allowAnyOrigin=true;
	
	public final boolean allowSubdomains=true;
    /**
     *
     */
    public final Set<String> supportedMethods;
	
	public final boolean supportAnyHeader= true;

    public corsonf() {
        this.supportedMethods = new HashSet<>();
        this.supportedMethods.add("GET, POST, HEAD, OPTIONS");
    }

    
    
	
	
}