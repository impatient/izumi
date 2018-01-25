package org.bitbucket.pshirshov.izumi.distage.provisioning

import org.bitbucket.pshirshov.izumi.distage.model.DIKey

import scala.collection.mutable

case class ProvisionActive
(
  instances: mutable.HashMap[DIKey, Any] = mutable.HashMap[DIKey, Any]()
  , imports: mutable.HashMap[DIKey, Any] = mutable.HashMap[DIKey, Any]()
) extends Provision {
  def toImmutable: ProvisionImmutable = {
    ProvisionImmutable(instances.toMap, imports.toMap)
  }

  override def narrow(allRequiredKeys: Set[DIKey]): Provision = {
    toImmutable.narrow(allRequiredKeys)
  }

  override def extend(values: collection.Map[DIKey, Any]): Provision = {
    toImmutable.extend(values)
  }
}
