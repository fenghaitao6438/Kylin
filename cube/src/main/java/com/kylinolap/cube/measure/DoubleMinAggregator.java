/*
 * Copyright 2013-2014 eBay Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kylinolap.cube.measure;

import org.apache.hadoop.io.DoubleWritable;

/**
 * @author yangli9
 * 
 */
public class DoubleMinAggregator extends MeasureAggregator<DoubleWritable> {

    DoubleWritable min = null;

    @Override
    public void reset() {
        min = null;
    }

    @Override
    public void aggregate(DoubleWritable value) {
        if (min == null)
            min = new DoubleWritable(value.get());
        else if (min.get() > value.get())
            min.set(value.get());
    }

    @Override
    public DoubleWritable getState() {
        return min;
    }

    @Override
    public int getMemBytes() {
        return guessDoubleMemBytes();
    }

}
