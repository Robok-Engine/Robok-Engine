package org.gampiot.robok.ui.fragments.project.template.model;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import androidx.annotation.DrawableRes;

public class ProjectTemplate {
	
	public String name;
	public String packageName;
	public String zipFileName;
	public boolean javaSupport;
	public boolean kotlinSupport;
	@DrawableRes public int imageResId;
	
	public void setName (String name) {
		this.name = name;
	}

	public void setJavaSupport (boolean javaSupport) {
		this.javaSupport = javaSupport;
	} 
	
	public void setKotlinSupport (boolean kotlinSupport) {
		this.kotlinSupport = kotlinSupport;
	}
	
	public void setImage (@DrawableRes int imageResId) {
		this.imageResId = imageResId;
	}
	
	public void setPackageName (String packageName) {
		this.packageName = packageName;
	}
	
	public void setZipFileName (String zipFileName) {
		this.zipFileName = zipFileName + ".zip";
	}
}
