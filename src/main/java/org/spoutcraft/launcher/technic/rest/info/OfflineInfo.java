/*
 * This file is part of Technic Launcher.
 *
 * Copyright (c) 2013-2013, Technic <http://www.technicpack.net/>
 * Technic Launcher is licensed under the Spout License Version 1.
 *
 * Technic Launcher is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Technic Launcher is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.launcher.technic.rest.info;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.spoutcraft.launcher.util.ResourceUtils;
import org.spoutcraft.launcher.util.Utils;

public class OfflineInfo {
	private final String name;
	private final String version;
	
	public OfflineInfo(String name, String version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public BufferedImage getLogo() throws IOException {
		BufferedImage image;
		File temp = new File(Utils.getAssetsDirectory(), getName() + File.separator + "logo.png");
		if (temp.exists()) {
			image = ImageIO.read(temp);
		} else {
			image = ImageIO.read(ResourceUtils.getResourceAsStream("/org/spoutcraft/launcher/resources/noLogo.png"));
		}
		return image;
	}

	public BufferedImage getIcon() throws IOException {
		BufferedImage image;
		File temp = new File(Utils.getAssetsDirectory(), getName() + File.separator + "icon.png");
		if (temp.exists()) {
			image = ImageIO.read(temp);
		} else {
			image = getLogo();
		}
		return image;
	}

	public BufferedImage getBackground() throws IOException {
		BufferedImage image;
		File temp = new File(Utils.getAssetsDirectory(), getName() + File.separator + "background.jpg");
		if (temp.exists()) {
			image = ImageIO.read(temp);
		} else {
			image = ImageIO.read(ResourceUtils.getResourceAsStream("/org/spoutcraft/launcher/resources/background.jpg"));
		}
		return image;
	}
}
