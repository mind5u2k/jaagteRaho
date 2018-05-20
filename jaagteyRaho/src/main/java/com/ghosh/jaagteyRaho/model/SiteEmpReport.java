package com.ghosh.jaagteyRaho.model;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.Site;
import com.ghosh.jaagteyRahoBackend.dto.SiteEmployeeMapping;

public class SiteEmpReport {

	private Site site;
	private List<SiteEmployeeMapping> mappings;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<SiteEmployeeMapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<SiteEmployeeMapping> mappings) {
		this.mappings = mappings;
	}

}
