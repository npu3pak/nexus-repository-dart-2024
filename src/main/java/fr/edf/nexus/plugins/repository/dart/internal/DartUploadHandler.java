/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package fr.edf.nexus.plugins.repository.dart.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.repository.Repository;
import org.sonatype.nexus.repository.rest.UploadDefinitionExtension;
import org.sonatype.nexus.repository.security.ContentPermissionChecker;
import org.sonatype.nexus.repository.security.VariableResolverAdapter;
import org.sonatype.nexus.repository.view.Content;

import fr.edf.nexus.plugins.repository.dart.internal.model.DartComponentUpload;

/**
 * Support for uploading dart components via UI & API
 *
 */
@Named(DartFormat.NAME)
@Singleton
public class DartUploadHandler extends DartUploadHandlerSupport {

    @Inject
    public DartUploadHandler(final ContentPermissionChecker contentPermissionChecker,
            @Named("simple") final VariableResolverAdapter variableResolverAdapter,
            final Set<UploadDefinitionExtension> uploadDefinitionExtensions) {
        super(contentPermissionChecker, variableResolverAdapter, uploadDefinitionExtensions);
    }

    @Override
    protected List<Content> getResponseContents(final Repository repository,
            final List<DartComponentUpload> componentsUpload) throws IOException {
        return new ArrayList<>();
    }

    @Override
    protected String normalizePath(final String path) {
        return "/" + super.normalizePath(path);
    }
}