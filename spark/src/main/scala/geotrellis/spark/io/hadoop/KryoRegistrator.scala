/*
 * Copyright (c) 2014 DigitalGlobe.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package geotrellis.spark.io.hadoop

import geotrellis.spark.io.hadoop.formats._
import org.apache.spark.serializer.{ KryoRegistrator => SparkKryoRegistrator }

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.serializers.FieldSerializer

class KryoRegistrator extends SparkKryoRegistrator {
  override def registerClasses(kryo: Kryo) {
    kryo.register(classOf[(_,_)])
    kryo.register(classOf[::[_]])
    kryo.register(classOf[geotrellis.spark.io.hadoop.SpatialKeyWritable])
    kryo.register(classOf[geotrellis.spark.io.hadoop.SpaceTimeKeyWritable])
    kryo.register(classOf[geotrellis.spark.io.hadoop.TileWritable])
    kryo.register(classOf[geotrellis.raster.BitArrayTile])
    kryo.register(classOf[geotrellis.raster.ByteArrayFiller])
    kryo.register(classOf[geotrellis.raster.FloatArrayTile])
    kryo.register(classOf[geotrellis.raster.DoubleArrayTile])
    kryo.register(classOf[geotrellis.raster.ShortArrayTile])
    kryo.register(classOf[geotrellis.raster.IntArrayTile])
    kryo.register(classOf[org.apache.accumulo.core.client.impl.ConnectorImpl])
    kryo.register(classOf[org.apache.accumulo.core.client.mock.MockConnector])
    kryo.register(classOf[geotrellis.spark.SpatialKey])
    kryo.register(classOf[geotrellis.spark.SpaceTimeKey])
    kryo.register(classOf[org.joda.time.DateTime], new de.javakaffee.kryoserializers.jodatime.JodaDateTimeSerializer)
    kryo.register(classOf[org.joda.time.Interval], new de.javakaffee.kryoserializers.jodatime.JodaIntervalSerializer)
    kryo.register(classOf[geotrellis.spark.io.index.rowmajor.RowMajorSpatialKeyIndex])
    kryo.register(classOf[geotrellis.spark.io.index.zcurve.ZSpatialKeyIndex])
    kryo.register(classOf[geotrellis.spark.io.index.zcurve.ZSpaceTimeKeyIndex])
    kryo.register(classOf[geotrellis.spark.io.index.hilbert.HilbertSpatialKeyIndex])
    kryo.register(classOf[geotrellis.spark.io.index.hilbert.HilbertSpaceTimeKeyIndex])
    kryo.register(classOf[geotrellis.vector.ProjectedExtent])
    kryo.register(classOf[geotrellis.vector.Extent])
    kryo.register(classOf[geotrellis.proj4.CRS])

    // de.javakaffee.kryoserializers.UnmodifiableCollectionsSerializer.registerSerializers(kryo)
    import java.util.{Arrays, Collections}
    import de.javakaffee.kryoserializers._

    kryo.register( Arrays.asList( "" ).getClass, new ArraysAsListSerializer )
    kryo.register( Collections.EMPTY_LIST.getClass, new CollectionsEmptyListSerializer() )
    kryo.register( Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer() )
    kryo.register( Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer() )
    kryo.register( Collections.singletonList( "" ).getClass(), new CollectionsSingletonListSerializer )
    kryo.register( Collections.singleton( "" ).getClass(), new CollectionsSingletonSetSerializer )
    kryo.register( Collections.singletonMap( "", "" ).getClass(), new CollectionsSingletonMapSerializer )
    kryo.register(geotrellis.spark.buffer.BufferTiles.Center.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.Top.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.Bottom.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.Left.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.Right.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.TopLeft.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.TopRight.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.BottomLeft.getClass)
    kryo.register(geotrellis.spark.buffer.BufferTiles.BottomRight.getClass)

    /* Exhaustive Registration */
    kryo.register(classOf[Array[Double]])
    kryo.register(classOf[Array[Float]])
    kryo.register(classOf[Array[Int]])
    kryo.register(classOf[Array[String]])
    kryo.register(classOf[Array[com.vividsolutions.jts.geom.Coordinate]])
    kryo.register(classOf[Array[com.vividsolutions.jts.geom.LinearRing]])
    kryo.register(classOf[Array[com.vividsolutions.jts.geom.Polygon]])
    kryo.register(classOf[Array[geotrellis.raster.Tile]])
    kryo.register(classOf[Array[geotrellis.spark.io.avro.AvroRecordCodec[Any]]])
    kryo.register(classOf[Array[geotrellis.spark.io.hadoop.SpaceTimeKeyWritable]])
    kryo.register(classOf[Array[geotrellis.spark.io.hadoop.SpatialKeyWritable]])
    kryo.register(classOf[Array[geotrellis.spark.SpaceTimeKey]])
    kryo.register(classOf[Array[geotrellis.spark.SpatialKey]])
    kryo.register(classOf[Array[geotrellis.vector.Feature[Any,Any]]])
    kryo.register(classOf[Array[geotrellis.vector.MultiPolygon]])
    kryo.register(classOf[Array[geotrellis.vector.Point]])
    kryo.register(classOf[Array[geotrellis.vector.Polygon]])
    kryo.register(classOf[Array[scala.collection.Seq[Any]]])
    kryo.register(classOf[Array[scala.Tuple2[Any,Any]]])
    kryo.register(classOf[Array[scala.Tuple3[Any,Any,Any]]])
    kryo.register(classOf[com.vividsolutions.jts.geom.Coordinate])
    kryo.register(classOf[com.vividsolutions.jts.geom.Envelope])
    kryo.register(classOf[com.vividsolutions.jts.geom.GeometryFactory])
    kryo.register(classOf[com.vividsolutions.jts.geom.impl.CoordinateArraySequence])
    kryo.register(classOf[com.vividsolutions.jts.geom.impl.CoordinateArraySequenceFactory])
    kryo.register(classOf[com.vividsolutions.jts.geom.LinearRing])
    kryo.register(classOf[com.vividsolutions.jts.geom.MultiPolygon])
    kryo.register(classOf[com.vividsolutions.jts.geom.Point])
    kryo.register(classOf[com.vividsolutions.jts.geom.Polygon])
    kryo.register(classOf[com.vividsolutions.jts.geom.PrecisionModel])
    kryo.register(classOf[com.vividsolutions.jts.geom.PrecisionModel.Type])
    kryo.register(classOf[geotrellis.raster.ArrayMultiBandTile])
    kryo.register(classOf[geotrellis.raster.ArrayTile])
    kryo.register(classOf[geotrellis.raster.ByteArrayTile])
    kryo.register(classOf[geotrellis.raster.CellGrid])
    kryo.register(classOf[geotrellis.raster.CellSize])
    kryo.register(classOf[geotrellis.raster.CompositeTile])
    kryo.register(classOf[geotrellis.raster.ConstantTile])
    kryo.register(classOf[geotrellis.raster.CroppedTile])
    kryo.register(classOf[geotrellis.raster.EmptyTile])
    kryo.register(classOf[geotrellis.raster.GridBounds])
    kryo.register(classOf[geotrellis.raster.GridExtent])
    kryo.register(classOf[geotrellis.raster.histogram.ArrayHistogram])
    kryo.register(classOf[geotrellis.raster.histogram.CompressedArrayHistogram])
    kryo.register(classOf[geotrellis.raster.histogram.ConstantHistogram])
    kryo.register(classOf[geotrellis.raster.histogram.FastMapHistogram])
    kryo.register(classOf[geotrellis.raster.histogram.Histogram])
    kryo.register(classOf[geotrellis.raster.histogram.MapHistogram])
    kryo.register(classOf[geotrellis.raster.histogram.MutableHistogram])
    kryo.register(classOf[geotrellis.raster.IntBasedArrayTile])
    kryo.register(classOf[geotrellis.raster.IterableTile])
    kryo.register(classOf[geotrellis.raster.KernelStamper])
    kryo.register(classOf[geotrellis.raster.LazyConvertedArrayTile])
    kryo.register(classOf[geotrellis.raster.MultiBandTile])
    kryo.register(classOf[geotrellis.raster.MutableArrayTile])
    kryo.register(classOf[geotrellis.raster.op.zonal.summary.MeanResult])
    kryo.register(classOf[geotrellis.raster.ProjectedRaster[Any]])
    kryo.register(classOf[geotrellis.raster.Raster[Any]])
    kryo.register(classOf[geotrellis.raster.RasterExtent])
    kryo.register(classOf[geotrellis.raster.Tile])
    kryo.register(classOf[geotrellis.raster.TileLayout])
    kryo.register(classOf[geotrellis.raster.TypeBit$])
    kryo.register(classOf[geotrellis.raster.TypeDouble$])
    kryo.register(classOf[geotrellis.raster.TypeFloat$])
    kryo.register(classOf[geotrellis.raster.TypeInt$])
    kryo.register(classOf[geotrellis.raster.TypeShort$])
    kryo.register(classOf[geotrellis.raster.TypeUByte$])
    kryo.register(classOf[geotrellis.raster.UByteArrayTile])
    kryo.register(classOf[geotrellis.raster.UShortArrayTile])
    kryo.register(classOf[geotrellis.spark.buffer.BufferSizes])
    kryo.register(classOf[geotrellis.spark.io.avro.AvroRecordCodec[Any]])
    kryo.register(classOf[geotrellis.spark.io.avro.AvroUnionCodec[Any]])
    kryo.register(classOf[geotrellis.spark.io.avro.codecs.KeyValueRecordCodec[Any,Any]])
    kryo.register(classOf[geotrellis.spark.io.avro.codecs.TupleCodec[Any,Any]])
    kryo.register(classOf[geotrellis.spark.io.hadoop.SpaceTimeKeyWritable])
    kryo.register(classOf[geotrellis.spark.io.hadoop.SpatialKeyWritable])
    kryo.register(classOf[geotrellis.spark.KeyBounds[Any]])
    kryo.register(classOf[geotrellis.vector.Feature[Any,Any]])
    kryo.register(classOf[geotrellis.vector.Geometry])
    kryo.register(classOf[geotrellis.vector.GeometryCollection])
    kryo.register(classOf[geotrellis.vector.Line])
    kryo.register(classOf[geotrellis.vector.MultiGeometry])
    kryo.register(classOf[geotrellis.vector.MultiLine])
    kryo.register(classOf[geotrellis.vector.MultiPoint])
    kryo.register(classOf[geotrellis.vector.MultiPolygon])
    kryo.register(classOf[geotrellis.vector.Point])
    kryo.register(classOf[geotrellis.vector.Polygon])
    kryo.register(classOf[geotrellis.vector.SpatialIndex[Any]])
    kryo.register(classOf[java.lang.Class[Any]])
    kryo.register(classOf[java.util.HashMap[Any,Any]])
    kryo.register(classOf[java.util.HashSet[Any]])
    kryo.register(classOf[java.util.LinkedHashMap[Any,Any]])
    kryo.register(classOf[java.util.LinkedHashSet[Any]])
    kryo.register(classOf[org.apache.accumulo.core.client.BatchWriterConfig])
    kryo.register(classOf[org.apache.accumulo.core.data.Key])
    kryo.register(classOf[org.apache.accumulo.core.data.Value])
    kryo.register(classOf[org.osgeo.proj4j.CoordinateReferenceSystem])
    kryo.register(classOf[org.osgeo.proj4j.datum.Datum])
    kryo.register(classOf[org.osgeo.proj4j.datum.Ellipsoid])
    kryo.register(classOf[org.osgeo.proj4j.proj.LambertConformalConicProjection])
    kryo.register(classOf[org.osgeo.proj4j.units.Unit])
    kryo.register(classOf[scala.collection.mutable.WrappedArray$ofRef])
    kryo.register(classOf[scala.collection.Seq[Any]])
    kryo.register(classOf[scala.Tuple3[Any,Any,Any]])

    /* Special Handling: Problematic Classes */
    {
      val cs = List(
        "geotrellis.proj4.LatLng$",
        "geotrellis.spark.EmptyBounds$",
        "scala.collection.immutable.Nil$",
        "scala.math.Ordering$Double$",
        "scala.math.Ordering$Float$",
        "scala.math.Ordering$Int$",
        "scala.math.Ordering$Long$",
        "scala.None$"
      )

      cs.foreach({ c => kryo.register(java.lang.Class.forName(c)) })
    }

    /* Special Handling: Avro */
    {
      import org.apache.avro.Schema

      val booleanSchema = Schema.create(Schema.Type.BOOLEAN)
      val bytesSchema = Schema.create(Schema.Type.BYTES)
      val doubleSchema = Schema.create(Schema.Type.DOUBLE)
      val floatSchema = Schema.create(Schema.Type.FLOAT)
      val intSchema = Schema.create(Schema.Type.INT)
      val longSchema = Schema.create(Schema.Type.LONG)
      val nullSchema = Schema.create(Schema.Type.NULL)
      val stringSchema = Schema.create(Schema.Type.STRING)

      val fields = new java.util.ArrayList[Schema.Field]
      val field = new Schema.Field("a", Schema.create(Schema.Type.NULL), null, null)
      fields.add(field)
      val schemas = new java.util.ArrayList[Schema]
      schemas.add(booleanSchema); schemas.add(bytesSchema)
      val enums = new java.util.ArrayList[String]
      enums.add("b"); enums.add("c")

      kryo.register(field.getClass)       // Field
      kryo.register(field.order.getClass) // Field$order
      kryo.register(classOf[Schema.Type]) // Schema$Type

      kryo.register(booleanSchema.getClass) // Boolean
      kryo.register(bytesSchema.getClass)   // Bytes
      kryo.register(doubleSchema.getClass)  // Double
      kryo.register(floatSchema.getClass)   // Float
      kryo.register(intSchema.getClass)     // Int
      kryo.register(longSchema.getClass)    // Long
      kryo.register(nullSchema.getClass)    // Null
      kryo.register(stringSchema.getClass)  // String

      kryo.register(Schema.createArray(nullSchema).getClass)          // Array
      kryo.register(Schema.createEnum("d", "e", "f", enums).getClass) // Enum
      kryo.register(Schema.createFixed("g", "h", "i", 1).getClass)    // Fixed
      kryo.register(Schema.createMap(nullSchema).getClass)            // Map
      kryo.register(Schema.createRecord(fields).getClass)             // Record
      kryo.register(Schema.createUnion(schemas).getClass)             // Union

      kryo.register(java.lang.Class.forName("org.apache.avro.Schema$LockableArrayList"))
      kryo.register(java.lang.Class.forName("org.apache.avro.Schema$Name"))
    }

    /* Special Handling: Anonymous Objects */
    {
      val anonymous = List(
        "geotrellis.proj4.CRS$$anon$",
        "geotrellis.spark.io.avro.codecs.KeyCodecs$$anon$",
        "geotrellis.spark.io.avro.codecs.TileCodecs$$anon$",
        "geotrellis.spark.SpaceTimeKey$$anonfun$ordering$",
        "geotrellis.spark.SpatialKey$$anonfun$ordering$",
        "geotrellis.spark.TemporalKey$$anonfun$ordering$",
        "scala.math.Ordering$$anon$",
        "scala.math.Ordering$$anonfun$by$",
        "scala.reflect.ClassTag$$anon$"
      )

      // The exact "names" of these anonymous objects may or may not
      // be known at the time of this file's compilation.  Therefore,
      // generate guesses at runtime.
      (1 to 17).foreach({ i =>
        anonymous.foreach({ anon =>
          try {
            kryo.register(Class.forName(anon + i))
          }
          catch {
            case e: java.lang.ClassNotFoundException =>
          }
        })
      })
    }

    UnmodifiableCollectionsSerializer.registerSerializers( kryo )
    SynchronizedCollectionsSerializer.registerSerializers( kryo )
  }
}
