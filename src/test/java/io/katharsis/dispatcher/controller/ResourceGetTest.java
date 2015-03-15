package io.katharsis.dispatcher.controller;

import io.katharsis.path.PathBuilder;
import io.katharsis.path.ResourcePath;
import io.katharsis.resource.registry.ResourceRegistry;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ResourceGetTest {
    @Test
    public void onGivenRequestCollectionGetShouldDenyIt() {
        // GIVEN
        String path = "/resource/";
        String requestType = "GET";
        PathBuilder pathBuilder = new PathBuilder();
        ResourcePath resourcePath = pathBuilder.buildPath(path);

        ResourceRegistry resourceRegistry = mock(ResourceRegistry.class);
        ResourceGet sut = new ResourceGet(resourceRegistry);

        // WHEN
        boolean result = sut.isAcceptable(resourcePath, requestType);

        // THEN
        Assert.assertEquals(result, false);
    }

    @Test
    public void onGivenRequestResourceGetShouldAcceptIt() {
        // GIVEN
        String path = "/resource/2";
        String requestType = "GET";
        PathBuilder pathBuilder = new PathBuilder();
        ResourcePath resourcePath = pathBuilder.buildPath(path);

        ResourceRegistry resourceRegistry = mock(ResourceRegistry.class);
        ResourceGet sut = new ResourceGet(resourceRegistry);

        // WHEN
        boolean result = sut.isAcceptable(resourcePath, requestType);

        // THEN
        Assert.assertEquals(result, true);
    }
}
